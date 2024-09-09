package gay.nyako.vanityslots.mixin;

import gay.nyako.vanityslots.CommonClass;
import gay.nyako.vanityslots.Config;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.monster.piglin.PiglinAi;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import java.util.ArrayList;
import java.util.List;

@Mixin(PiglinAi.class)
public class PiglinAiMixin {
    @Redirect(method = "isWearingGold", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/LivingEntity;getArmorAndBodyArmorSlots()Ljava/lang/Iterable;"))
    private static Iterable<ItemStack> vanityslots$isWearingGold(LivingEntity entity) {
        if (!Config.MOBS_REACT_TO_VANITY.get()) {
            return entity.getArmorSlots();
        }

        List<ItemStack> visibleArmor = new ArrayList<>((List<ItemStack>) entity.getArmorSlots());

        if (entity instanceof Player) {
            for (var slot : EquipmentSlot.values())
            {
                if (slot.getType() != EquipmentSlot.Type.HUMANOID_ARMOR) continue;
                var vanityItem = CommonClass.getVanityStack(entity, slot);
                if (!vanityItem.isEmpty())
                {
                    visibleArmor.set(slot.getIndex(), vanityItem);
                }
            }
        }

        return visibleArmor;
    }
}
