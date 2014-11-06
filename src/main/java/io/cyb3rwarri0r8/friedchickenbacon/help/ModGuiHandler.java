package io.cyb3rwarri0r8.friedchickenbacon.help;

import cpw.mods.fml.common.network.IGuiHandler;
import io.cyb3rwarri0r8.friedchickenbacon.client.container.ContainerDeepFryer;
import io.cyb3rwarri0r8.friedchickenbacon.client.container.ContainerOilPress;
import io.cyb3rwarri0r8.friedchickenbacon.client.gui.GuiFryer;
import io.cyb3rwarri0r8.friedchickenbacon.client.gui.GuiPress;
import io.cyb3rwarri0r8.friedchickenbacon.tileentity.TileEntityDeepFryer;
import io.cyb3rwarri0r8.friedchickenbacon.tileentity.TileEntityOilPress;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

/**
 * Created by noah on 10/8/14.
 */
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
