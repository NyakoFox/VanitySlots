package gay.nyako.vanityslots;

import net.fabricmc.api.ClientModInitializer;
import fuzs.forgeconfigapiport.fabric.api.neoforge.v4.client.ConfigScreenFactoryRegistry;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.world.item.CreativeModeTabs;
import net.neoforged.neoforge.client.gui.ConfigurationScreen;

public class VanitySlotsClientMod implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ConfigScreenFactoryRegistry.INSTANCE.register(Constants.MOD_ID, ConfigurationScreen::new);

        registerItemGroups();
    }

    private void registerItemGroups()
    {
        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.COMBAT)
                .register((itemGroup) -> {
                    itemGroup.accept(VanitySlotsItems.FAMILIAR_WIG);
                    itemGroup.accept(VanitySlotsItems.FAMILIAR_SHIRT);
                    itemGroup.accept(VanitySlotsItems.FAMILIAR_PANTS);
                    itemGroup.accept(VanitySlotsItems.FAMILIAR_SNEAKERS);
                });
    }
}
