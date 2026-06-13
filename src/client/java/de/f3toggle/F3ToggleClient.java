package de.f3toggle;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import net.minecraft.world.GameMode;
import org.lwjgl.glfw.GLFW;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Environment(EnvType.CLIENT)
public class F3ToggleClient implements ClientModInitializer {

    public static final String MOD_ID = "f3toggle";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    public static KeyBinding toggleKeyBinding;

    private static GameMode previousGameMode = null;
    private static boolean isToggled = false;
    private static boolean wasComboPressed = false;

    @Override
    public void onInitializeClient() {
        LOGGER.info("Creative Toggle Mod loaded!");
        F3ToggleConfig.load();

        toggleKeyBinding = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                "key.f3toggle.toggle",
                InputUtil.Type.KEYSYM,
                GLFW.GLFW_KEY_X,
                KeyBinding.Category.create(net.minecraft.util.Identifier.of("f3toggle", "category"))
        ));
        toggleKeyBinding.setBoundKey(InputUtil.Type.KEYSYM.createFromCode(F3ToggleConfig.getToggleKeyCode()));
        KeyBinding.updateKeysByCode();
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            if (client.player == null) return;

            boolean f3Down = GLFW.glfwGetKey(
                client.getWindow().getHandle(), GLFW.GLFW_KEY_F3) == GLFW.GLFW_PRESS;

            int boundCode = InputUtil.fromTranslationKey(toggleKeyBinding.getBoundKeyTranslationKey()).getCode();

            if (boundCode != F3ToggleConfig.getToggleKeyCode()) {
            F3ToggleConfig.setToggleKeyCodeSilent(boundCode);
}
            boolean toggleDown = GLFW.glfwGetKey(
                client.getWindow().getHandle(), boundCode) == GLFW.GLFW_PRESS;

            boolean comboNow = f3Down && toggleDown;

            if (comboNow && !wasComboPressed) {
                handleF3Toggle(client);
            }
            wasComboPressed = comboNow;
        });
    }

    public static void handleF3Toggle(MinecraftClient client) {
        if (client.player == null || client.interactionManager == null) return;

        GameMode currentMode = client.interactionManager.getCurrentGameMode();

        if (!isToggled) {
            previousGameMode = currentMode;
            isToggled = true;
            sendGameModeCommand(client, GameMode.CREATIVE);
        } else {
            isToggled = false;
            GameMode restore = (previousGameMode != null) ? previousGameMode : GameMode.SURVIVAL;
            previousGameMode = null;
            sendGameModeCommand(client, restore);
        }
    }

    private static void sendGameModeCommand(MinecraftClient client, GameMode mode) {
        String name = switch (mode) {
            case CREATIVE  -> "creative";
            case SPECTATOR -> "spectator";
            case ADVENTURE -> "adventure";
            default        -> "survival";
        };
        client.player.networkHandler.sendChatCommand("gamemode " + name);
    }
}