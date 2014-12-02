package io.cyb3rwarri0r8.betterfoods.help.proxy;
/* 
* Better Foods - A Minecraft Modification
* Copyright (C) 2014 Cyb3rWarri0r8
*
* This program is free software: you can redistribute it and/or modify 
* it under the terms of the GNU General Public License as published by
* the Free Software Foundation, either version 3 of the License, or
* any later version.
*
* This program is distributed in the hope that it will be useful,
* but WITHOUT ANY WARRANTY; without even the implied warranty of
* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
* GNU General Public License for more details.
*
* You should have received a copy of the GNU General Public License
* along with this program.  If not, see <http://www.gnu.org/licenses/>.
*/

import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import io.cyb3rwarri0r8.betterfoods.entity.TileEntityDeepFryer;
import io.cyb3rwarri0r8.betterfoods.entity.TileEntityOilPress;
import io.cyb3rwarri0r8.betterfoods.help.Reference;
import io.cyb3rwarri0r8.betterfoods.help.handlers.ModGuiHandler;
import io.cyb3rwarri0r8.betterfoods.main;

public abstract class proxyCommon {
    public void registerRenderers()
    {

    }

    public void registerSounds()
    {

    }

    public static void registerTileEntities()
    {
        GameRegistry.registerTileEntity(TileEntityDeepFryer.class, Reference.MODID + ":deepFryerTileEntity");
        GameRegistry.registerTileEntity(TileEntityOilPress.class, Reference.MODID + ":oilPressTileEntity");
    }

    public void registerNetwork()
    {
        NetworkRegistry.INSTANCE.registerGuiHandler(main.INSTANCE, new ModGuiHandler());
    }
}
