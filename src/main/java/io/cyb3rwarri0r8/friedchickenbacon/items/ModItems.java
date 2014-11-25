package io.cyb3rwarri0r8.friedchickenbacon.items;

import net.minecraft.item.Item;

/**
 * Created by noah on 9/4/14.
 */
public class ModItems {

    public static Item peanut;

    public static void loadItems()
    {

        peanut = new ItemPeanut(3, 3, false);

    }
}
