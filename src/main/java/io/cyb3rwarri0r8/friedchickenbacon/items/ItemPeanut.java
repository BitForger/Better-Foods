package io.cyb3rwarri0r8.friedchickenbacon.items;

import io.cyb3rwarri0r8.friedchickenbacon.help.ModItemSeeds;
import io.cyb3rwarri0r8.friedchickenbacon.help.Reference;
import io.cyb3rwarri0r8.friedchickenbacon.main;
import net.minecraft.block.Block;

/**
 * Created by noah on 10/13/14.
 */
public class ItemPeanut extends ModItemSeeds {
    public ItemPeanut(int hunger, int saturation, Block crop, Block soil)
    {
        super(hunger, saturation, crop, soil);
        setUnlocalizedName("peanut");
        setTextureName(Reference.MODID + ":" + getUnlocalizedName().substring(5));
        setCreativeTab(main.modTab);
    }
}
