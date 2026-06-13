package de.f3toggle;

import com.terraformersmc.modmenu.api.ConfigScreenFactory;
import com.terraformersmc.modmenu.api.ModMenuApi;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

/**
 * Integrates with Mod Menu so the config screen is reachable from the mods list.
 * This class is loaded only when Mod Menu is present (optional dependency).
 */
@Environment(EnvType.CLIENT)
public class F3ToggleModMenuIntegration implements ModMenuApi {

    @Override
    public ConfigScreenFactory<?> getModConfigScreenFactory() {
        return F3ToggleConfigScreen::new;
    }
}
