package com.bbexx.stm.Item;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;

public class ModItems {
    public static Item ingotCopper;
    public static Item Walkie_Talkie;

    public static void init() {
        ingotCopper = new ingotCopper();
        GameRegistry.registerItem(ingotCopper, "ingot_copper");

        OreDictionary.registerOre("ingot_copper", ingotCopper);

        Walkie_Talkie = new WalkieTalkie();
        GameRegistry.registerItem(Walkie_Talkie, "walkie_talkie");

        // Crafts
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Walkie_Talkie), new Object[]{
            "I  ",
            "IRI",
            "III",
            'I', "ingotCopper",
            'R', Items.redstone
        }));
    }
}
