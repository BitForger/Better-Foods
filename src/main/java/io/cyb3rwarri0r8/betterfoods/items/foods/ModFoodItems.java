package io.cyb3rwarri0r8.betterfoods.items.foods;
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

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ModFoodItems {
    public static Item rawBacon = new FoodRawBacon(3,3,true);
    public static Item cookedBacon = new FoodCookedBacon(3,6,false);

    public static void loadFoodItems()
    {

        GameRegistry.registerItem(rawBacon, "rawBacon");
        GameRegistry.addShapelessRecipe(new ItemStack(rawBacon, 4), new Object[]{
                Items.porkchop
        } );

        GameRegistry.registerItem(cookedBacon,"cookedBacon");
        GameRegistry.addSmelting(rawBacon, new ItemStack(cookedBacon,1),20F);
    }
}
