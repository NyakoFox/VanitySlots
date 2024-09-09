package gay.nyako.vanityslots.mixin;

import gay.nyako.vanityslots.CommonClass;
import net.minecraft.client.gui.Gui;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(Gui.class)
public class GuiMixin {
    @Redirect(method = "renderCameraOverlays", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/player/Inventory;getArmor(I)Lnet/minecraft/world/item/ItemStack;"))
    public ItemStack vanityslots$render(Inventory instance, int slot) {
        EquipmentSlot slotType = null;
        for (EquipmentSlot equipmentSlot : EquipmentSlot.values()) {
            if (equipmentSlot.getIndex() == slot) {
                // Get slot type from equipment slot
                slotType = equipmentSlot;
                break;
            }
        }

        if (slotType == null) {
            return instance.getArmor(slot);
        }

        ItemStack vanity = CommonClass.getVanityStack(instance.player, slotType);
        if (!vanity.isEmpty()) {
            return vanity;
        }

        return instance.getArmor(slot);
    }
}
