package com.bbexx.stm.GUI;

import com.bbexx.stm.GUI.WalkieTalkie.WalkieGUI;
import cpw.mods.fml.common.network.IGuiHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class GuiHandler implements IGuiHandler {

    // СЕРВЕРНАЯ СТОРОНА: Нужна только если в интерфейсе есть слоты для предметов (как в сундуке)
    // Так как у рации слотов нет, сервер возвращает null
    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        return null;
    }

    // КЛИЕНТСКАЯ СТОРОНА: Именно здесь создаются экраны интерфейсов для отрисовки
    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        if (ID == 0) {
            return new WalkieGUI(); // Откроется при обычном ПКМ
        }
        return null;
    }
}
