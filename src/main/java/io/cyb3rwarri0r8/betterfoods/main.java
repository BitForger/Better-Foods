package io.cyb3rwarri0r8.betterfoods;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import io.cyb3rwarri0r8.betterfoods.blocks.ModBlocks;
import io.cyb3rwarri0r8.betterfoods.help.creativetabs.CreativeTabsMod;
import io.cyb3rwarri0r8.betterfoods.fooditems.ModFoodItems;
import io.cyb3rwarri0r8.betterfoods.help.Reference;
import io.cyb3rwarri0r8.betterfoods.items.ModItems;
import io.cyb3rwarri0r8.betterfoods.proxy.proxyCommon;
import net.minecraft.creativetab.CreativeTabs;

/* ${PROJECT_NAME} - A Minecraft Modification
* Copyright (C) 2014 Cyb3rWarri0r8
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
* along with this program.  If not, see <http://www.gnu.org/licenses/>.
*/
@Mod(modid = Reference.MODID, version = Reference.Version)
public class main {

    @Mod.Instance
    public static main instance;

    public static CreativeTabs modTab = new CreativeTabsMod("betterfoods");

    @SidedProxy(clientSide=Reference.proxyClient, serverSide=Reference.proxyCommon)
    public static proxyCommon proxy;

    @Mod.EventHandler
    public void preinit(FMLPreInitializationEvent event)
    {

        ModBlocks.loadBlocks();
        ModFoodItems.loadFoodItems();
        ModItems.loadItems();


        proxy.registerNetwork();
        proxy.registerTileEntities();
        proxy.registerRenderers();

    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event)
    {



    }


}
