package com.bbexx.stm.Item;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;

public class ModItems {
    public static Item newItem; // Изменили имя переменной для порядка

    public static void init() {
        newItem = new NewItem(); // Теперь это сработает без ошибок
        GameRegistry.registerItem(newItem, "newItem");
    }
}
