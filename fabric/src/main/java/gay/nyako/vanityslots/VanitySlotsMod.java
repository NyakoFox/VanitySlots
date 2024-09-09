package gay.nyako.vanityslots;

import net.fabricmc.api.ModInitializer;

public class VanitySlotsMod implements ModInitializer {
    
    @Override
    public void onInitialize() {
        CommonClass.init();

        VanitySlotsItems.register();
    }
}
