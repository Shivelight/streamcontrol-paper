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

import org.bukkit.plugin.java.JavaPlugin;

public final class StreamControl extends JavaPlugin {

    ConfigAccessor config;

    @Override
    public void onEnable() {
        config = new ConfigAccessor(this, "config.yml");
        config.getConfig().options().copyDefaults(true);
        config.saveConfig();
        getCommand("streamcontrol").setExecutor(new Reload(this));
        getServer().getPluginManager().registerEvents(new Event(this), this);
    }

}
