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

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class Reload implements CommandExecutor {

    private StreamControl plugin;

    Reload(StreamControl plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("streamcontrol")) {
            if (args.length == 1 && args[0].equalsIgnoreCase("reload")) {
                if (sender.hasPermission("streamcontrol.use")) {
                    plugin.config.reloadConfig();
                    sender.sendMessage(Util.colorize("&eStreamControl reloaded!"));
                    return true;
                }
            }

            String authors = String.join(", ", plugin.getDescription().getAuthors());
            String version = plugin.getDescription().getVersion();
            sender.sendMessage(Util.colorize("StreamControl &7version &e" + version));
            sender.sendMessage(Util.colorize("Authors: &e" + authors + "&e&l ❤"));
            // By returning false, server will send out available commands.
            return !sender.hasPermission("streamcontrol.use");
        }

        return true;
    }

}
