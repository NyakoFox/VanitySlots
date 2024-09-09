package gay.nyako.vanityslots.mixin;

import gay.nyako.vanityslots.CommonClass;
import net.minecraft.client.renderer.entity.layers.CustomHeadLayer;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(CustomHeadLayer.class)
public class CustomHeadLayerMixin<T extends LivingEntity> {
    @Redirect(method = "render(Lcom/mojang/blaze3d/vertex/PoseStack;Lnet/minecraft/client/renderer/MultiBufferSource;ILnet/minecraft/world/entity/LivingEntity;FFFFFF)V", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/LivingEntity;getItemBySlot(Lnet/minecraft/world/entity/EquipmentSlot;)Lnet/minecraft/world/item/ItemStack;"))
    public ItemStack vanityslots$getOverlayArmor(T entity, EquipmentSlot slot) {
        if (!(entity instanceof Player))
            return entity.getItemBySlot(slot);

        ItemStack vanity = CommonClass.getVanityStack(entity, slot);
        if (!vanity.isEmpty()) {
            return vanity;
        }

        return entity.getItemBySlot(slot);
    }
}
