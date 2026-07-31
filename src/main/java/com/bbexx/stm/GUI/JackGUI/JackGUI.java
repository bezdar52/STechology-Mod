package com.bbexx.stm.GUI.JackGUI;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.util.ChatComponentText;

public class JackGUI extends GuiScreen {

    private final String title;
    private final String text;

    public JackGUI(String title, String text) {
        this.title = title;
        this.text = text;
    }

    @Override
    public void initGui() {
        this.buttonList.clear();

        int buttonWidth = 80;
        int buttonHeight = 20;
        int centerX = this.width / 2;
        int centerY = this.height / 2;

        // Создаем кнопки. Убедитесь, что ID (0 и 1) не конфликтуют внутри этого экрана
        this.buttonList.add(new GuiButton(0, centerX - buttonWidth - 10, centerY + 20, buttonWidth, buttonHeight, "Да"));
        this.buttonList.add(new GuiButton(1, centerX + 10, centerY + 20, buttonWidth, buttonHeight, "Нет"));
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        // Отрисовка дефолтного заднего фона (затемнение мира)
        this.drawDefaultBackground();

        int centerX = this.width / 2;
        int centerY = this.height / 2;

        // ВАЖНО: fontRendererObj может быть null, если вызвать его слишком рано.
        // Здесь он вызывается внутри drawScreen, когда mc уже полностью инициализировал экран.
        if (this.fontRendererObj != null) {
            this.drawCenteredString(this.fontRendererObj, this.title, centerX, centerY - 30, 0xFFFFFF);
            this.drawCenteredString(this.fontRendererObj, this.text, centerX, centerY - 10, 0xA0A0A0);
        }

        super.drawScreen(mouseX, mouseY, partialTicks);
    }

    @Override
    protected void actionPerformed(GuiButton button) {
        if (button.id == 0) {
            this.mc.thePlayer.addChatMessage(new ChatComponentText("Вы согласились на квест Джека!"));
        } else if (button.id == 1) {
            this.mc.thePlayer.addChatMessage(new ChatComponentText("Вы отклонили квест!"));
        }
        // Закрываем окно
        this.mc.displayGuiScreen(null);
    }

    @Override
    public boolean doesGuiPauseGame() {
        return false;
    }
}
