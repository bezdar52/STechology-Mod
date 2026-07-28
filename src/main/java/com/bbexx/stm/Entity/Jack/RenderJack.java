package com.bbexx.stm.Entity.Jack;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class RenderJack extends RenderBiped {

    // Путь к файлу текстуры: src/main/resources/assets/mymod/textures/entity/mynpc.png
    private static final ResourceLocation textureLocation =
        new ResourceLocation("stm", "textures/entity/jacknpc.png");

    public RenderJack() {
        super(new ModelBiped(), 0.5F); // Модель и размер тени под НПС
    }

    @Override
    protected ResourceLocation getEntityTexture(Entity entity) {
        return textureLocation;
    }
}
