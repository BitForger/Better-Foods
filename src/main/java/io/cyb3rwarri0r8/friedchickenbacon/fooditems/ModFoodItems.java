package io.cyb3rwarri0r8.friedchickenbacon.fooditems;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

/**
 * Created by noah on 9/4/14.
 */
public class ModFoodItems {

    public static Item rawBacon = new FoodRawBacon(3,3,true);
    public static Item cookedBacon = new FoodCookedBacon(3,6,false);

    public static void loadFoodItems()
    {

        GameRegistry.registerItem(rawBacon,"rawBacon");
        GameRegistry.addShapelessRecipe(new ItemStack(rawBacon, 4), new Object[]{
                Items.porkchop
        } );

        GameRegistry.registerItem(cookedBacon,"cookedBacon");
        GameRegistry.addSmelting(rawBacon, new ItemStack(cookedBacon,1),20F);
    }
}
