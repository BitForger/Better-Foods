package io.cyb3rwarri0r8.betterfoods.items;

import io.cyb3rwarri0r8.betterfoods.help.ModItemSeeds;
import io.cyb3rwarri0r8.betterfoods.help.Reference;
import io.cyb3rwarri0r8.betterfoods.main;
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
