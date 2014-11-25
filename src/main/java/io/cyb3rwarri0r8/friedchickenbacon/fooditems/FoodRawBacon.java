package io.cyb3rwarri0r8.friedchickenbacon.fooditems;

import io.cyb3rwarri0r8.friedchickenbacon.help.Reference;
import io.cyb3rwarri0r8.friedchickenbacon.main;
import net.minecraft.item.ItemFood;

/**
 * Created by noah on 9/4/14.
 */
public class FoodRawBacon extends ItemFood {
    public FoodRawBacon(int hunger, float saturation, boolean isWolfFood) {
        super(hunger, saturation, isWolfFood);
        setUnlocalizedName("rawBacon");
        setTextureName(Reference.MODID + ":" + getUnlocalizedName().substring(5));
        setCreativeTab(main.modTab);
    }
}
