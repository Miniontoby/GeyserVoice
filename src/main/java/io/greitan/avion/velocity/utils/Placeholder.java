package io.greitan.avion.velocity.utils;

import org.bukkit.entity.Player;

import io.greitan.avion.common.utils.BasePlaceholder;
import io.greitan.avion.velocity.GeyserVoice;

public class Placeholder extends BasePlaceholder {
    private final GeyserVoice plugin;

    // Get the plugin interface.
    public Placeholder(GeyserVoice plugin) {
        this.plugin = plugin;
    }

    @Override
    public String onPlaceholderRequest(Player player, String identifier) {
        // Voice icon placeholder "%voice_status%"
        if (identifier.equalsIgnoreCase("status")) {
            if (plugin.getPlayerBinds().getOrDefault(player.getName(), false)) {
                return GeyserVoice.getConfig().getString("config.voice.in-voice-symbol");
            } else {
                return GeyserVoice.getConfig().getString("config.voice.not-in-voice-symbol");
            }
        }
        return null;
    }
}