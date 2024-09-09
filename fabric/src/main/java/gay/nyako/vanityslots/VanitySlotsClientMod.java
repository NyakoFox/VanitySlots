package gay.nyako.vanityslots;

import net.fabricmc.api.ClientModInitializer;
import fuzs.forgeconfigapiport.fabric.api.neoforge.v4.client.ConfigScreenFactoryRegistry;
import net.neoforged.neoforge.client.gui.ConfigurationScreen;

public class VanitySlotsClientMod implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ConfigScreenFactoryRegistry.INSTANCE.register(Constants.MOD_ID, ConfigurationScreen::new);
    }
}
