package gay.nyako.vanityslots;

import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

public class VanitySlotsItems {
    public static final Holder<ArmorMaterial> VANITY_ARMOR_MATERIAL = registerMaterial("vanity_armor",
            Map.of(
                    ArmorItem.Type.HELMET, 1,
                    ArmorItem.Type.CHESTPLATE, 3,
                    ArmorItem.Type.LEGGINGS, 2,
                    ArmorItem.Type.BOOTS, 1
            ),
            15,
            SoundEvents.ARMOR_EQUIP_LEATHER,
            () -> Ingredient.of(Items.LEATHER),
            0.0F,
            0.0F,
            false
    );
    public static final Item FAMILIAR_WIG = register(Utils.id("familiar_wig"), new ArmorItem(VANITY_ARMOR_MATERIAL, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final Item FAMILIAR_SHIRT = register(Utils.id("familiar_shirt"), new ArmorItem(VANITY_ARMOR_MATERIAL, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final Item FAMILIAR_PANTS = register(Utils.id("familiar_pants"), new ArmorItem(VANITY_ARMOR_MATERIAL, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final Item FAMILIAR_SNEAKERS = register(Utils.id("familiar_sneakers"), new ArmorItem(VANITY_ARMOR_MATERIAL, ArmorItem.Type.BOOTS, new Item.Properties()));

    public static Item register(ResourceLocation id, Item item)
    {
        return Registry.register(BuiltInRegistries.ITEM, id, item);
    }

    public static void register() {
        // Do nothing
    }

    public static Holder<ArmorMaterial> registerMaterial(String id, Map<ArmorItem.Type, Integer> defensePoints, int enchantability, Holder<SoundEvent> equipSound, Supplier<Ingredient> repairIngredientSupplier, float toughness, float knockbackResistance, boolean dyeable) {
        List<ArmorMaterial.Layer> layers = List.of(
                new ArmorMaterial.Layer(Utils.id(id), "", dyeable)
        );

        ArmorMaterial material = new ArmorMaterial(defensePoints, enchantability, equipSound, repairIngredientSupplier, layers, toughness, knockbackResistance);
        // Register the material within the ArmorMaterials registry.
        material = Registry.register(BuiltInRegistries.ARMOR_MATERIAL, Utils.id(id), material);

        // The majority of the time, you'll want the RegistryEntry of the material - especially for the ArmorItem constructor.
        return Holder.direct(material);
    }
}
