package com.bbexx.stm.creativeTabs;

import net.minecraft.creativetab.CreativeTabs;

public class ModTabs {

    // Сюда запишется готовая вкладка для использования в предметах
    public static CreativeTabs tabOres;

    public static void init() {
        tabOres = new OresTab("OresTab");
    }
}
