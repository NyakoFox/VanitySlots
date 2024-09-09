package gay.nyako.vanityslots;


import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.registries.RegisterEvent;

@Mod(Constants.MOD_ID)
public class VanitySlotsMod {
    public VanitySlotsMod(IEventBus eventBus) {
        CommonClass.init();
        eventBus.addListener(this::onRegister);
    }

    private void onRegister(RegisterEvent event)
    {
        VanitySlotsItems.register();
    }
}