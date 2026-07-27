package com.bbexx.stm.Item;

import com.bbexx.stm.GUI.WalkieGUI;
import com.bbexx.stm.creativeTabs.ModTabs;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.world.World;

public class WalkieTalkie extends Item {

    public WalkieTalkie() {
        super();
        this.setUnlocalizedName("walkie_talkie");
        this.setTextureName("stm:walkie_talkie");
        this.setCreativeTab(ModTabs.tabItems);

        // Max 1 items in stack
        this.setMaxStackSize(1);
    }

    @Override
    public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player) {
        if (world.isRemote) {
            Minecraft.getMinecraft().displayGuiScreen(new WalkieGUI());
        }
        return itemStack;
    }
}
