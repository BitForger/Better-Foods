package io.cyb3rwarri0r8.betterfoods.lib.handlers;
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

import cpw.mods.fml.common.network.IGuiHandler;
import io.cyb3rwarri0r8.betterfoods.client.container.ContainerDeepFryer;
import io.cyb3rwarri0r8.betterfoods.client.container.ContainerOilPress;
import io.cyb3rwarri0r8.betterfoods.client.gui.GuiFryer;
import io.cyb3rwarri0r8.betterfoods.client.gui.GuiPress;
import io.cyb3rwarri0r8.betterfoods.entity.TileEntityDeepFryer;
import io.cyb3rwarri0r8.betterfoods.entity.TileEntityOilPress;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class ModGuiHandler implements IGuiHandler {
    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        if(ID == 0)
        {
            TileEntityDeepFryer tileEntity = (TileEntityDeepFryer) world.getTileEntity(x, y, z);
            return new ContainerDeepFryer(player.inventory, tileEntity);
        }
        else if(ID == 1)
        {
            TileEntityOilPress tileEntity = (TileEntityOilPress) world.getTileEntity(x, y, z);
            return new ContainerOilPress(player.inventory, tileEntity);
        }
        return null;
    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        if(ID == 0)
        {
            TileEntityDeepFryer tileEntity = (TileEntityDeepFryer) world.getTileEntity(x, y, z);
            return new GuiFryer(player.inventory, tileEntity);
        }
        else if (ID == 1)
        {
            TileEntityOilPress tileEntity = (TileEntityOilPress) world.getTileEntity(x, y, z);
            return new GuiPress(player.inventory, tileEntity);
        }
        return null;
    }
}
