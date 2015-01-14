package io.cyb3rwarri0r8.betterfoods;
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

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import io.cyb3rwarri0r8.betterfoods.blocks.ModBlocks;
import io.cyb3rwarri0r8.betterfoods.lib.Reference;
import io.cyb3rwarri0r8.betterfoods.lib.creativetabs.CreativeTabsMod;
import io.cyb3rwarri0r8.betterfoods.lib.proxy.proxyCommon;
import io.cyb3rwarri0r8.betterfoods.items.ModItems;
import io.cyb3rwarri0r8.betterfoods.items.foods.ModFoodItems;
import net.minecraft.creativetab.CreativeTabs;

@Mod(modid = Reference.MODID, version = Reference.VERSION)
public class main {
    @Mod.Instance
    public static main INSTANCE;

    @SidedProxy(clientSide = Reference.PROXYCLIENTCLASS, serverSide = Reference.PROXYCOMMONCLASS)
    public static proxyCommon proxy;

    public static CreativeTabs modTab = new CreativeTabsMod("betterfoods");

    @Mod.EventHandler
    public void preinit(FMLPreInitializationEvent event)
    {

        ModBlocks.loadBlocks();
        ModFoodItems.loadFoodItems();
        ModItems.init();


        proxy.registerNetwork();
        proxy.registerTileEntities();
        proxy.registerRenderers();

    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event)
    {



    }



}
