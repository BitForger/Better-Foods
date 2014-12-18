package io.cyb3rwarri0r8.betterfoods.blocks;
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

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import io.cyb3rwarri0r8.betterfoods.help.Reference;
import io.cyb3rwarri0r8.betterfoods.help.cropshelper.ModBlockCrops;
import io.cyb3rwarri0r8.betterfoods.items.ModItems;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import net.minecraft.util.IIcon;

import java.util.Random;

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
        iIcons[0] = parIIconRegister.registerIcon(Reference.MODID + ":" + getUnlocalizedName().substring(5) + "_0");
        iIcons[1] = parIIconRegister.registerIcon(Reference.MODID + ":" + getUnlocalizedName().substring(5) + "_0");
        iIcons[2] = parIIconRegister.registerIcon(Reference.MODID + ":" + getUnlocalizedName().substring(5) + "_1");
        iIcons[3] = parIIconRegister.registerIcon(Reference.MODID + ":" + getUnlocalizedName().substring(5) + "_1");
        iIcons[4] = parIIconRegister.registerIcon(Reference.MODID + ":" + getUnlocalizedName().substring(5) + "_2");
        iIcons[5] = parIIconRegister.registerIcon(Reference.MODID + ":" + getUnlocalizedName().substring(5) + "_2");
        iIcons[6] = parIIconRegister.registerIcon(Reference.MODID + ":" + getUnlocalizedName().substring(5) + "_3");
        iIcons[7] = parIIconRegister.registerIcon(Reference.MODID + ":" + getUnlocalizedName().substring(5) + "_3");
    }
}
