package io.cyb3rwarri0r8.friedchickenbacon.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import io.cyb3rwarri0r8.friedchickenbacon.help.ModBlockCrops;
import io.cyb3rwarri0r8.friedchickenbacon.help.Reference;
import io.cyb3rwarri0r8.friedchickenbacon.items.ModItems;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import net.minecraft.util.IIcon;

import java.util.Random;

/**
 * Created by noah on 11/6/14.
 */
public class BlockPeanuts extends ModBlockCrops {
    public BlockPeanuts()
    {
        setBlockName("peanutCrops");
        setBlockTextureName(Reference.MODID + ":" + "peanutCrops_0");
    }

    @Override
    public int quantityDropped(int parMetadata, int parFortune, Random parRand)
    {
        return (parMetadata/2);
    }

    @Override
    public Item getItemDropped(int parMetadata, Random parRand, int parFortune)
    {
        // DEBUG
        System.out.println("BlockPeanuts getItemDropped()");
        return (ModItems.peanut);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister parIIconRegister)
    {
        iIcons = new IIcon[maxGrowthStage+1];
        // seems that crops like to have 8 growth icons, but okay to repeat actual texture if you want

        // to make generic should loop to maxGrowthStage
        iIcons[0] = parIIconRegister.registerIcon(Reference.MODID + ":" + getUnlocalizedName() + "_stage0");
        iIcons[1] = parIIconRegister.registerIcon(Reference.MODID + ":" + getUnlocalizedName() + "_stage0");
        iIcons[2] = parIIconRegister.registerIcon(Reference.MODID + ":" + getUnlocalizedName() + "_stage1");
        iIcons[3] = parIIconRegister.registerIcon(Reference.MODID + ":" + getUnlocalizedName() + "_stage1");
        iIcons[4] = parIIconRegister.registerIcon(Reference.MODID + ":" + getUnlocalizedName() + "_stage2");
        iIcons[5] = parIIconRegister.registerIcon(Reference.MODID + ":" + getUnlocalizedName() + "_stage2");
        iIcons[6] = parIIconRegister.registerIcon(Reference.MODID + ":" + getUnlocalizedName() + "_stage3");
        iIcons[7] = parIIconRegister.registerIcon(Reference.MODID + ":" + getUnlocalizedName() + "_stage3");
    }
}
