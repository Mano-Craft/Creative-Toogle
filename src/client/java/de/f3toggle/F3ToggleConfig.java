package de.f3toggle;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.loader.api.FabricLoader;
import org.lwjgl.glfw.GLFW;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;

import java.io.*;
import java.nio.file.Path;

@Environment(EnvType.CLIENT)
public class F3ToggleConfig {

    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    private static final Path CONFIG_PATH = FabricLoader.getInstance()
            .getConfigDir().resolve("f3toggle.json");

    // Default toggle key: X  (GLFW key code)
    private static int toggleKeyCode = GLFW.GLFW_KEY_X;

    public static int getToggleKeyCode() {
        return toggleKeyCode;
    }

    public static void setToggleKeyCode(int keyCode) {
        toggleKeyCode = keyCode;
        if (F3ToggleClient.toggleKeyBinding != null) {
        F3ToggleClient.toggleKeyBinding.setBoundKey(
            InputUtil.Type.KEYSYM.createFromCode(keyCode)
        );
        KeyBinding.updateKeysByCode();
        }
        save();
    }
    public static void setToggleKeyCodeSilent(int keyCode) {
    toggleKeyCode = keyCode;
    save();
}  

    public static void load() {
        if (!CONFIG_PATH.toFile().exists()) {
            save();
            return;
        }
        try (Reader reader = new FileReader(CONFIG_PATH.toFile())) {
            ConfigData data = GSON.fromJson(reader, ConfigData.class);
            if (data != null && data.toggleKeyCode > 0) {
                toggleKeyCode = data.toggleKeyCode;
            }
        } catch (Exception e) {
            F3ToggleClient.LOGGER.error("Failed to load F3Toggle config", e);
            save();
        }
    }

    public static void save() {
        try (Writer writer = new FileWriter(CONFIG_PATH.toFile())) {
            ConfigData data = new ConfigData();
            data.toggleKeyCode = toggleKeyCode;
            GSON.toJson(data, writer);
        } catch (Exception e) {
            F3ToggleClient.LOGGER.error("Failed to save F3Toggle config", e);
        }
    }

    /** Returns the display name of the configured key (e.g. "X", "Z", "C"). */
    public static String getToggleKeyName() {
        // Try to get the GLFW key name
        String name = GLFW.glfwGetKeyName(toggleKeyCode, 0);
        if (name != null) return name.toUpperCase();
        // Fallback for special keys
        return "Key " + toggleKeyCode;
    }

    // ── Serialization model ─────────────────────────────────────────────────
    private static class ConfigData {
        int toggleKeyCode = GLFW.GLFW_KEY_X;
    }
}
