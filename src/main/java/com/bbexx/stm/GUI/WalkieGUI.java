package com.bbexx.stm.GUI;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import org.lwjgl.input.Keyboard;

public class WalkieGUI extends GuiScreen {

    private static int currentChannel = 1;

    @Override
    public void initGui() {
        this.buttonList.clear();

        int baseWidth = 60;
        int baseHeight = 20;
        int centerX = this.width / 2;
        int centerY = this.height / 2;

        // Кнопка переключения канала НАЗАД (ID: 0)
        this.buttonList.add(new GuiButton(0, centerX - 70, centerY, baseWidth, baseHeight, "<<"));

        // Кнопка переключения канала ВПЕРЕД (ID: 1)
        this.buttonList.add(new GuiButton(1, centerX + 10, centerY, baseWidth, baseHeight, ">>"));

        // Кнопка ВЫХОД (ID: 2) в правом верхнем углу экрана
        // Отступаем по 10 пикселей от правого и верхнего края
        int exitButtonWidth = 50;
        int exitButtonHeight = 20;
        int exitX = this.width - exitButtonWidth - 10;
        int exitY = 10;

        this.buttonList.add(new GuiButton(2, exitX, exitY, exitButtonWidth, exitButtonHeight, "Выйти"));
    }

    @Override
    protected void actionPerformed(GuiButton button) {
        if (button.id == 0) {
            if (currentChannel > 1) currentChannel--;
        }
        if (button.id == 1) {
            if (currentChannel < 99) currentChannel++;
        }
        // Обработка нажатия на кнопку "Выйти"
        if (button.id == 2) {
            this.closeGui();
        }
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        this.drawDefaultBackground();

        this.drawCenteredString(this.fontRendererObj, "Рация STM-1", this.width / 2, this.height / 2 - 50, 0x00FF00);

        String channelText = "Канал: " + currentChannel;
        this.drawCenteredString(this.fontRendererObj, channelText, this.width / 2, this.height / 2 - 20, 0xFFFFFF);

        super.drawScreen(mouseX, mouseY, partialTicks);
    }

    @Override
    protected void keyTyped(char typedChar, int keyCode) {
        if (keyCode == Keyboard.KEY_ESCAPE) {
            this.closeGui();
        }
    }

    // Вынесли логику закрытия в отдельный метод, чтобы не дублировать код
    private void closeGui() {
        this.mc.displayGuiScreen((GuiScreen) null);
        this.mc.setIngameFocus();
    }

    @Override
    public boolean doesGuiPauseGame() {
        return false;
    }
}
