package io.cyb3rwarri0r8.friedchickenbacon;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import io.cyb3rwarri0r8.friedchickenbacon.blocks.ModBlocks;
import io.cyb3rwarri0r8.friedchickenbacon.creativetabs.CreativeTabsMod;
import io.cyb3rwarri0r8.friedchickenbacon.fooditems.ModFoodItems;
import io.cyb3rwarri0r8.friedchickenbacon.help.Reference;
import io.cyb3rwarri0r8.friedchickenbacon.items.ModItems;
import io.cyb3rwarri0r8.friedchickenbacon.proxy.proxyCommon;
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

    public static CreativeTabs modTab = new CreativeTabsMod("friedChickenBacon");

    @SidedProxy(clientSide="io.cyb3rwarri0r8.friedchickenbacon.proxy.proxyClient", serverSide="io.cyb3rwarri0r8.friedchickenbacon.proxy.proxyCommon")
    public static proxyCommon proxy;

    @Mod.EventHandler
    public void preinit(FMLPreInitializationEvent event)
    {

        ModFoodItems.loadFoodItems();
        ModItems.loadItems();
        ModBlocks.loadBlocks();

        proxy.registerNetwork();
        proxy.registerTileEntities();
        proxy.registerRenderers();

    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event)
    {



    }


}
