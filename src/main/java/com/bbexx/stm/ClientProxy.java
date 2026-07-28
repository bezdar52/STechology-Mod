package com.bbexx.stm;

import com.bbexx.stm.Entity.Jack.Jack;
import com.bbexx.stm.Entity.Jack.RenderJack;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.event.FMLInitializationEvent;

public class ClientProxy extends CommonProxy {

    @Override
    public void init(FMLInitializationEvent event) {
        // Сначала выполняем то, что написано в CommonProxy.init (если там что-то есть)
        super.init(event);

        // Связываем сущность НПС с классом её отрисовки
        RenderingRegistry.registerEntityRenderingHandler(Jack.class, new RenderJack());
    }
}
