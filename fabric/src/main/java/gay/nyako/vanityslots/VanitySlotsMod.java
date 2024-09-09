package gay.nyako.vanityslots;

import net.fabricmc.api.ModInitializer;
import fuzs.forgeconfigapiport.fabric.api.neoforge.v4.NeoForgeConfigRegistry;
import net.neoforged.fml.config.ModConfig;

public class VanitySlotsMod implements ModInitializer {
    
    @Override
    public void onInitialize() {
        CommonClass.init();

        VanitySlotsItems.register();

        NeoForgeConfigRegistry.INSTANCE.register(Constants.MOD_ID, ModConfig.Type.SERVER, Config.CONFIG);
    }
}
