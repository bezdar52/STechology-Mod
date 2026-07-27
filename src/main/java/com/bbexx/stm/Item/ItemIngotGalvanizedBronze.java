package com.bbexx.stm.Item;

import com.bbexx.stm.creativeTabs.ModTabs;
import net.minecraft.item.Item;

public class ItemIngotGalvanizedBronze extends Item {
    public ItemIngotGalvanizedBronze() {
        super();
        this.setUnlocalizedName("ItemIngotGalvanizedBronze");
        this.setTextureName("stm:ignot_galvanized_bronze");
        this.setCreativeTab(ModTabs.tabOres);
    }
}
