package io.cyb3rwarri0r8.betterfoods.proxy;

import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import io.cyb3rwarri0r8.betterfoods.help.ModGuiHandler;
import io.cyb3rwarri0r8.betterfoods.help.Reference;
import io.cyb3rwarri0r8.betterfoods.main;
import io.cyb3rwarri0r8.betterfoods.tileentity.TileEntityDeepFryer;
import io.cyb3rwarri0r8.betterfoods.tileentity.TileEntityOilPress;

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
