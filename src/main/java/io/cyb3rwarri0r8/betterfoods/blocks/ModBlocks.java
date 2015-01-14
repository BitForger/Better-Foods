package io.cyb3rwarri0r8.betterfoods.blocks;
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

import io.cyb3rwarri0r8.betterfoods.lib.RegisterHelper;
import io.cyb3rwarri0r8.betterfoods.main;
import net.minecraft.block.Block;

public class ModBlocks {
    public static Block deepFryer_idle;
    public static Block deepFryer_active;

    public static Block oilPress_idle;
    public static Block oilPress_active;

    public static Block peanutCrop;


    public static void loadBlocks()
    {
        deepFryer_idle = new BlockDeepFryer(false).setBlockName("deepFryerIdle").setCreativeTab(main.modTab);
        RegisterHelper.registerBlock(deepFryer_idle);

        deepFryer_active = new BlockDeepFryer(true).setBlockName("deepFryerActive");
        RegisterHelper.registerBlock(deepFryer_active);

        oilPress_idle = new BlockOilPress(false).setBlockName("oilPressIdle").setCreativeTab(main.modTab);
        RegisterHelper.registerBlock(oilPress_idle);

        oilPress_active = new BlockOilPress(true).setBlockName("oilPressActive");
        RegisterHelper.registerBlock(oilPress_active);

        peanutCrop = new BlockPeanuts();
        RegisterHelper.registerBlock(peanutCrop);

    }
}
