package de.f3toggle;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.text.Text;
import org.lwjgl.glfw.GLFW;

/**
 * Simple configuration screen accessible via Mod Menu or the Options → Controls flow.
 *
 * The player clicks "Change Key", then presses the desired key.
 * The new key is saved immediately to disk via F3ToggleConfig.
 */
@Environment(EnvType.CLIENT)
public class F3ToggleConfigScreen extends Screen {

    private final Screen parent;
    private boolean waitingForKey = false;
    private ButtonWidget changeKeyButton;

    public F3ToggleConfigScreen(Screen parent) {
        super(Text.translatable("f3toggle.config.title"));
        this.parent = parent;
    }

    @Override
    protected void init() {
        int centerX = this.width / 2;
        int centerY = this.height / 2;

        // "Change Key" button
        changeKeyButton = ButtonWidget.builder(
                Text.translatable("f3toggle.config.change_key",
                        F3ToggleConfig.getToggleKeyName()),
                button -> {
                    waitingForKey = true;
                    button.setMessage(Text.translatable("f3toggle.config.press_key"));
                }
        ).dimensions(centerX - 100, centerY - 10, 200, 20).build();

        this.addDrawableChild(changeKeyButton);

        // "Done" button
        this.addDrawableChild(
                ButtonWidget.builder(
                        Text.translatable("gui.done"),
                        button -> this.close()
                ).dimensions(centerX - 75, centerY + 25, 150, 20).build()
        );
    }

    @Override
    public boolean keyPressed(net.minecraft.client.input.KeyInput input) {
    if (waitingForKey) {
        int keyCode = input.key();
        if (keyCode == GLFW.GLFW_KEY_ESCAPE) {
            waitingForKey = false;
            refreshChangeKeyButton();
            return true;
        }
        F3ToggleConfig.setToggleKeyCode(keyCode);
        waitingForKey = false;
        refreshChangeKeyButton();
        return true;
    }
    return super.keyPressed(input);
}

    private void refreshChangeKeyButton() {
        if (changeKeyButton != null) {
            changeKeyButton.setMessage(
                    Text.translatable("f3toggle.config.change_key",
                            F3ToggleConfig.getToggleKeyName())
            );
        }
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        super.render(context, mouseX, mouseY, delta);
        // Title
        context.drawCenteredTextWithShadow(
                this.textRenderer,
                this.title,
                this.width / 2,
                this.height / 2 - 50,
                0xFFFFFF
        );
        // Current key hint
        context.drawCenteredTextWithShadow(
                this.textRenderer,
                Text.translatable("f3toggle.config.current_key",
                        F3ToggleConfig.getToggleKeyName()),
                this.width / 2,
                this.height / 2 - 30,
                0xAAAAAA
        );
        if (waitingForKey) {
            context.drawCenteredTextWithShadow(
                    this.textRenderer,
                    Text.translatable("f3toggle.config.waiting"),
                    this.width / 2,
                    this.height / 2 + 55,
                    0xFFFF55
            );
        }
    }

    @Override
    public void close() {
        assert this.client != null;
        this.client.setScreen(parent);
    }
}
