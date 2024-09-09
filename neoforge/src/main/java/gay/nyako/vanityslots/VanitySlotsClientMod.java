package gay.nyako.vanityslots;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.client.gui.ConfigurationScreen;
import net.neoforged.neoforge.client.gui.IConfigScreenFactory;

@Mod(value = Constants.MOD_ID, dist = Dist.CLIENT)
public class VanitySlotsClientMod {
    public VanitySlotsClientMod(ModContainer container)
    {
        container.registerExtensionPoint(IConfigScreenFactory.class, ConfigurationScreen::new);
    }
}
