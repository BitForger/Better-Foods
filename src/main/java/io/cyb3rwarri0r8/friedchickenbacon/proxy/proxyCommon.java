package io.cyb3rwarri0r8.friedchickenbacon.proxy;

import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import io.cyb3rwarri0r8.friedchickenbacon.help.ModGuiHandler;
import io.cyb3rwarri0r8.friedchickenbacon.help.Reference;
import io.cyb3rwarri0r8.friedchickenbacon.main;
import io.cyb3rwarri0r8.friedchickenbacon.tileentity.TileEntityDeepFryer;
import io.cyb3rwarri0r8.friedchickenbacon.tileentity.TileEntityOilPress;

/**
 * Created by noah on 10/6/14.
 */
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
        NetworkRegistry.INSTANCE.registerGuiHandler(main.instance, new ModGuiHandler());
    }
}
