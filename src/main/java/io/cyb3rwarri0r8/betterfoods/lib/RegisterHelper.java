package io.cyb3rwarri0r8.betterfoods.lib;
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

import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import io.cyb3rwarri0r8.betterfoods.lib.recipes.DeepFryerRecipes;
import io.cyb3rwarri0r8.betterfoods.lib.recipes.OilPressRecipes;
import io.cyb3rwarri0r8.betterfoods.main;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityList;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import java.util.Random;

public class RegisterHelper {
    public static void registerBlock(Block block)
    {
        GameRegistry.registerBlock(block, Reference.MODID + ":" + block.getUnlocalizedName().substring(5));
    }

    // ********************************************************************************************

    public static void registerItem(Item item)
    {
        GameRegistry.registerItem(item, Reference.MODID + ":" + item.getUnlocalizedName().substring(5));
    }

    // ********************************************************************************************

    public static void regToolRecipe(Item item, Item x, Item y, String toolType)
    {
        if (toolType == "pickaxe")
        {
            GameRegistry.addRecipe(new ItemStack(item),
                    "XXX",
                    " Y ",
                    " Y ",
                    'X', x, 'Y', y
            );
        }
        else if (toolType == "axe")
        {
            GameRegistry.addRecipe(new ItemStack(item),
                    "XX",
                    "XY",
                    " Y",
                    'X', x, 'Y', y);
        }
        else if (toolType == "shovel")
        {
            GameRegistry.addRecipe(new ItemStack(item),
                    "X",
                    "Y",
                    "Y",
                    'X', x, 'Y', y);
        }
        else if (toolType == "hoe")
        {
            GameRegistry.addRecipe(new ItemStack(item),
                    "XY",
                    " Y",
                    " Y",
                    'X', x, 'Y', y);
        }
        else if (toolType == "sword")
        {
            GameRegistry.addRecipe(new ItemStack(item),
                    "X",
                    "X",
                    "Y",
                    'X', x, 'Y', y);
        }
        else
        {
            System.out.println("Error: Cannot register recipe!");
        }
    }

    // ********************************************************************************************

    public static void regArmorRecipe(Item item, Item x, String armortype)
    {
        if (armortype == "helmet")
        {
            GameRegistry.addRecipe(new ItemStack(item),
                    "XXX",
                    "X X",
                    'X', x);
        }else if (armortype == "chestplate")
        {
            GameRegistry.addRecipe(new ItemStack(item),
                    "X X",
                    "XXX",
                    "XXX",
                    'X', x
            );
        }else if (armortype == "leggings")
        {
            GameRegistry.addRecipe(new ItemStack(item),
                    "XXX",
                    "X X",
                    "X X",
                    'X', x
            );
        } else if (armortype == "boots")
        {
            GameRegistry.addRecipe(new ItemStack(item),
                    "X X",
                    "X X",
                    'X', x
            );
        } else
        {
            System.out.println("Error: Invalid Armor type!");
        }
    }

    // ********************************************************************************************

    public static void registerEntity(Class entityClass, String name)
    {

        int entityID = EntityRegistry.findGlobalUniqueEntityId();
        long seed = name.hashCode();
        Random rand = new Random(seed);
        int primaryColor = rand.nextInt() * 16777215;
        int secondaryColor = rand.nextInt() * 16777215;

        EntityRegistry.registerGlobalEntityID(entityClass, name, entityID);
        EntityRegistry.registerModEntity(entityClass, name, entityID, main.INSTANCE, 64, 1, true);
        EntityList.entityEggs.put(Integer.valueOf(entityID), new EntityList.EntityEggInfo(entityID, primaryColor, secondaryColor));

    }

    public static void registerDeepFryerRecipe(Item item, ItemStack itemStack, float xp)
    {
        DeepFryerRecipes.smelting().addRecipe(item, itemStack, xp);
    }

    public static void registerOilPressRecipe(Item item, ItemStack itemStack, float xp)
    {
        OilPressRecipes.smelting().addRecipe(item, itemStack, xp);
    }
}
