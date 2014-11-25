package io.cyb3rwarri0r8.betterfoods.help.creativetabs;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import io.cyb3rwarri0r8.betterfoods.fooditems.ModFoodItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

/**
 * Created by noah on 9/4/14.
 */
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
