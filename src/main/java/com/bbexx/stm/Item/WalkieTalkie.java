package com.bbexx.stm.Item;

import com.bbexx.stm.StmMod;
import com.bbexx.stm.creativeTabs.ModTabs;
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
        // openGui запускается И на клиенте, И на сервере автоматически
        // Передаем: (Экземпляр мода, ID интерфейса, мир, координаты игрока)
//        if (player.isSneaking()) {
//            player.openGui(StmMod.instance, 1, world, (int)player.posX, (int)player.posY, (int)player.posZ);
//        } else {
//            player.openGui(StmMod.instance, 0, world, (int)player.posX, (int)player.posY, (int)player.posZ);
//        }
        player.openGui(StmMod.instance, 0, world, (int)player.posX, (int)player.posY, (int)player.posZ);
        return itemStack;
    }
}
