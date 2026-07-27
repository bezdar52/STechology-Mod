package com.bbexx.stm.Item;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;

public class ModItems {
    public static Item Ingot_GalvanizedBronze;
    public static Item Walkie_Talkie;

    public static void init() {
        Ingot_GalvanizedBronze = new ItemIngotGalvanizedBronze();
        GameRegistry.registerItem(Ingot_GalvanizedBronze, "IngotGalvanizedBronze");

        Walkie_Talkie = new WalkieTalkie();
        GameRegistry.registerItem(Walkie_Talkie, "WalkieTalkie");
    }
}
