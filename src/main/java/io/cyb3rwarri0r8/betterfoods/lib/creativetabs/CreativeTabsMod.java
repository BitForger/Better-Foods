package io.cyb3rwarri0r8.betterfoods.lib.creativetabs;
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

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import io.cyb3rwarri0r8.betterfoods.items.foods.ModFoodItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class CreativeTabsMod extends CreativeTabs {
    public CreativeTabsMod(String tabName) {
        super(tabName);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public Item getTabIconItem() {
        return ModFoodItems.cookedBacon;
    }
}
