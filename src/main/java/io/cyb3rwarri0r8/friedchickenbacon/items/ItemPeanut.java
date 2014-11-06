package io.cyb3rwarri0r8.friedchickenbacon.items;

import io.cyb3rwarri0r8.friedchickenbacon.blocks.ModBlocks;
import io.cyb3rwarri0r8.friedchickenbacon.help.ModItemSeeds;
import io.cyb3rwarri0r8.friedchickenbacon.help.Reference;
import net.minecraft.init.Blocks;

/**
 * Created by noah on 10/13/14.
 */
public class ItemPeanut extends ModItemSeeds {
    public ItemPeanut(int hunger, int saturation, boolean isWolfFood) {
        super(hunger, saturation, ModBlocks.peanutCrop, Blocks.dirt);
        setTextureName(Reference.MODID + ":" + getUnlocalizedName().substring(5));
    }
}
