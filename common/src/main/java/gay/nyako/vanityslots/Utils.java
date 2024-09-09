package gay.nyako.vanityslots;

import net.minecraft.resources.ResourceLocation;

public class Utils {
    public static ResourceLocation id(String string)
    {
        return ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, string);
    }
}
