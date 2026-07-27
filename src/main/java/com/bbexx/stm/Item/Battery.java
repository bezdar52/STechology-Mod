package com.bbexx.stm.Item;

import com.bbexx.stm.creativeTabs.ModTabs;
import net.minecraft.item.Item;

public class Battery extends Item {

    public Battery() {
        super();
        this.setUnlocalizedName("battery");
        this.setTextureName("stm:battery");
        this.setCreativeTab(ModTabs.tabItems);

        // Max 5 items in stack
        this.setMaxStackSize(5);
    }
}
