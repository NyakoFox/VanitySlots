package gay.nyako.vanityslots;

import io.wispforest.accessories.api.AccessoriesAPI;
import io.wispforest.accessories.api.slot.SlotReference;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;

public class CommonClass {
    public static boolean USE_VANITY = false;

    public static void init() {
        /*
        if (Services.PLATFORM.isModLoaded("vanityslots")) {

            Constants.LOG.info("Hello to vanityslots");
        }*/
    }

    public static ItemStack getVanityStack(LivingEntity entity, EquipmentSlot slot) {
        if (!(entity instanceof Player)) return ItemStack.EMPTY;

        return switch (slot)
        {
            case HEAD -> SlotReference.of(entity, "vanity_hat", 0).getStack();
            case CHEST -> SlotReference.of(entity, "vanity_shirt", 0).getStack();
            case LEGS -> SlotReference.of(entity, "vanity_pants", 0).getStack();
            case FEET -> SlotReference.of(entity, "vanity_shoes", 0).getStack();
            default -> ItemStack.EMPTY;
        };
    }

    public static ItemStack getEquippedStack(LivingEntity entity, EquipmentSlot slot) {
        if (!(entity instanceof Player))
            return entity.getItemBySlot(slot);

        ItemStack vanity = getVanityStack(entity, slot);
        if (!vanity.isEmpty())
        {
            return vanity;
        }

        return entity.getItemBySlot(slot);
    }
}