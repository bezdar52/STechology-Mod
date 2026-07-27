package com.bbexx.stm.Item;

import com.bbexx.stm.creativeTabs.ModTabs;
import net.minecraft.item.Item;

public class ingotCopper extends Item {
    public ingotCopper() {
        super();
        this.setUnlocalizedName("ingot_copper");
        this.setTextureName("stm:ingot_copper");
        this.setCreativeTab(ModTabs.tabOres);
    }
}
