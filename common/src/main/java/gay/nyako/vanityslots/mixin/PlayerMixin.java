package gay.nyako.vanityslots.mixin;

import gay.nyako.vanityslots.CommonClass;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Player.class)
public abstract class PlayerMixin extends LivingEntity {
    @Shadow @Final private Inventory inventory;

    protected PlayerMixin(EntityType<? extends LivingEntity> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    @Inject(method = "getItemBySlot", at = @At("HEAD"), cancellable = true)
    private void injected(EquipmentSlot slot, CallbackInfoReturnable<ItemStack> cir) {
        if (slot.getType() == EquipmentSlot.Type.HUMANOID_ARMOR) {
            if (CommonClass.USE_VANITY) {
                ItemStack vanity = CommonClass.getVanityStack(this, slot);
                if (!vanity.isEmpty()) {
                    cir.setReturnValue(vanity);
                    return;
                }
            }
            cir.setReturnValue(this.inventory.armor.get(slot.getIndex()));
        }
    }
}
