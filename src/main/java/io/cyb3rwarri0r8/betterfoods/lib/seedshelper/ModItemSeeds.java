package io.cyb3rwarri0r8.betterfoods.lib.seedshelper;
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

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.EnumPlantType;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.common.util.ForgeDirection;

public class ModItemSeeds extends ItemFood implements IPlantable {
    private final Block theBlockPlant;
    /**
     * Block ID of the soil this seed food should be planted on.
     */
    private final Block soilId;

    public ModItemSeeds(int healAmount, float saturation, Block crop, Block soil) {
        super(healAmount, saturation, false);
        this.theBlockPlant = crop;
        this.soilId = soil;
    }
    @Override
    public EnumPlantType getPlantType(IBlockAccess world, int x, int y, int z) {
        return EnumPlantType.Crop;
    }

    @Override
    public Block getPlant(IBlockAccess world, int x, int y, int z) {
        return theBlockPlant;
    }

    @Override
    public int getPlantMetadata(IBlockAccess world, int x, int y, int z) {
        return 0;
    }

    public Block getSoilId()
    {
        return soilId;
    }
    @Override
    public boolean onItemUse(ItemStack parItemStack, EntityPlayer parPlayer, World parWorld, int parX, int parY, int parZ, int par7, float par8, float par9, float par10) {
        // not sure what this parameter does, copied it from potato
        if (par7 != 1) {
            return false;
        }
        // check if player has capability to edit
        else if (parPlayer.canPlayerEdit(parX, parY + 1, parZ, par7, parItemStack)) {
            // check that the soil block can sustain the plant
            // and that block above is air so there is room for plant to grow
            if (parWorld.getBlock(parX, parY, parZ).canSustainPlant(parWorld, parX, parY, parZ, ForgeDirection.UP, this) && parWorld.isAirBlock(parX, parY + 1, parZ)) {
                // place the plant block
                parWorld.setBlock(parX, parY + 1, parZ, this.theBlockPlant);
                // decrement the stack of seed items
                --parItemStack.stackSize;
                return true;
            } else {
                return false;
            }
        }
        else {
            return false;
        }
    }

}
