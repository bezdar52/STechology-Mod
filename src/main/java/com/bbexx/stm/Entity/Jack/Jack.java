package com.bbexx.stm.Entity.Jack;

import com.bbexx.stm.StmMod;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class Jack extends EntityCreature {

    public Jack(World world) {
        super(world);
        this.setSize(0.6F, 1.8F);

        // ИИ: Оставляем только плавание и взгляд на игрока
        this.getNavigator().setAvoidsWater(true);
        this.tasks.addTask(0, new EntityAISwimming(this));
        // Увеличим радиус обзора до 10.0F, чтобы он замечал игрока дальше
        this.tasks.addTask(1, new EntityAIWatchClosest(this, EntityPlayer.class, 10.0F));
        this.tasks.addTask(2, new EntityAILookIdle(this));
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(20.0D);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.0D);
    }

    @Override
    public boolean canBePushed() {
        return false;
    }

    @Override
    public boolean attackEntityFrom(DamageSource source, float amount) {
         return false;
    }

    @Override
    public boolean interact(EntityPlayer player) {
        if (this.worldObj.isRemote) {
            player.openGui(StmMod.instance, 1, this.worldObj, (int)this.posX, (int)this.posY, (int)this.posZ);
        }
        return true;
    }
}
