/*
 * This file is part of StreamControl
 * (see https://github.com/Shivelight/streamcontrol-paper).
 *
 * Copyright (c) 2019 Shivelight.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */

package id.shivelight.paper.streamcontrol;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import java.util.List;

public class Event implements Listener {

    private StreamControl plugin;

    Event(StreamControl plugin) {
        this.plugin = plugin;
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onJoin(PlayerJoinEvent event) {
        if (plugin.config.getConfig().getBoolean("join-message-enabled")) {
            if (plugin.config.getConfig().getBoolean("first-join-only")) {
                if (!event.getPlayer().hasPlayedBefore()) {
                    String message = plugin.config.getConfig().getString("first-join-message");
                    if (!message.isEmpty()) {
                        message = message.replaceAll("%player%", event.getPlayer().getDisplayName());
                        event.setJoinMessage(message);
                    }
                } else {
                    event.setJoinMessage(null);
                }
            }

            String message = plugin.config.getConfig().getString("join-message");
            if (!message.isEmpty()) {
                message = message.replaceAll("%player%", event.getPlayer().getDisplayName());
                event.setJoinMessage(message);
            }
        } else {
            event.setJoinMessage(null);
        }

        if (plugin.config.getConfig().getBoolean("join-motd-enabled")) {
            List<String> message = plugin.config.getConfig().getStringList("join-motd-message");
            event.getPlayer().sendMessage(message.toArray(new String[0]));
        }
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onQuit(PlayerQuitEvent event) {
        if (!plugin.config.getConfig().getBoolean("quit-message-enabled")) {
            event.setQuitMessage(null);
        }
    }

}
