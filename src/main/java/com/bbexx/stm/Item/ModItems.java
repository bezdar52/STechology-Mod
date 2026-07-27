package com.bbexx.stm.Item;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;

public class ModItems {
    public static Item Ingot_GalvanizedBronze;

    public static void init() {
        Ingot_GalvanizedBronze = new ItemIngotGalvanizedBronze();
        GameRegistry.registerItem(Ingot_GalvanizedBronze, "IngotGalvanizedBronze");
    }
}
