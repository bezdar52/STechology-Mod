package com.bbexx.stm.Item;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item; // Импортируем класс Item

public class NewItem extends Item { // Добавляем наследование

    // Конструктор должен называться так же, как класс
    public NewItem() {
        super();
        this.setUnlocalizedName("newItem");
        this.setTextureName("stm:newItem");
        this.setCreativeTab(CreativeTabs.tabMisc);
    }
}
