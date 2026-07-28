package com.bbexx.stm.Entity;

import com.bbexx.stm.Entity.Jack.Jack;
import com.bbexx.stm.StmMod;
import cpw.mods.fml.common.registry.EntityRegistry;
import net.minecraft.entity.EntityList;

public class ModEntity {

    public static void init() {
        int entityID = 1;
        EntityRegistry.registerModEntity(
            Jack.class,
            "JackNPC",
            entityID,
            StmMod.instance,
            80, 3, true
        );

        String entityName = StmMod.MODID + ".JackNPC";

        // 3. Находим свободный глобальный ID для яйца
        int globalID = EntityRegistry.findGlobalUniqueEntityId();

        // 4. Регистрируем яйцо и связываем его с КЛАССОМ нашего NPC
        EntityList.IDtoClassMapping.put(Integer.valueOf(globalID), Jack.class);
        EntityList.entityEggs.put(
            Integer.valueOf(globalID),
            new EntityList.EntityEggInfo(globalID, 0x00FF00, 0x0000FF)
        );
    }
}
