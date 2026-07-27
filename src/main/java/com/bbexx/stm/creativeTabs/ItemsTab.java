package com.bbexx.stm.creativeTabs;

import com.bbexx.stm.Item.ModItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemsTab extends CreativeTabs {
    public ItemsTab(String label) {
        super(label);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public Item getTabIconItem() {
        return ModItems.Walkie_Talkie;
    }
}
