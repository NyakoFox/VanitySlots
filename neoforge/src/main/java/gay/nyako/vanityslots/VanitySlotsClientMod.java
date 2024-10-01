package gay.nyako.vanityslots;

import net.minecraft.world.item.CreativeModeTabs;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.client.gui.ConfigurationScreen;
import net.neoforged.neoforge.client.gui.IConfigScreenFactory;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;

@Mod(value = Constants.MOD_ID, dist = Dist.CLIENT)
public class VanitySlotsClientMod {
    public VanitySlotsClientMod(ModContainer container)
    {
        container.registerExtensionPoint(IConfigScreenFactory.class, ConfigurationScreen::new);

        var eventBus = container.getEventBus();
        eventBus.addListener(this::buildContents);
    }

    public void buildContents(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == CreativeModeTabs.COMBAT) {
            event.accept(VanitySlotsItems.FAMILIAR_WIG);
            event.accept(VanitySlotsItems.FAMILIAR_SHIRT);
            event.accept(VanitySlotsItems.FAMILIAR_PANTS);
            event.accept(VanitySlotsItems.FAMILIAR_SNEAKERS);
        }
    }
}
