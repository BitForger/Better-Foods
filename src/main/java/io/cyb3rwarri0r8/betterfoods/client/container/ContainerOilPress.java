package io.cyb3rwarri0r8.betterfoods.client.container;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import io.cyb3rwarri0r8.betterfoods.help.OilPressRecipes;
import io.cyb3rwarri0r8.betterfoods.tileentity.TileEntityOilPress;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.inventory.SlotFurnace;
import net.minecraft.item.ItemStack;

/**
 * Created by noah on 10/10/14.
 */
public class ContainerOilPress extends Container {
    private TileEntityOilPress tileEntity;
    private int lastCookTime;
    private int lastBurnTime;
    private int lastItemBurnTime;

    public ContainerOilPress(InventoryPlayer invPlayer, TileEntityOilPress entityOilPress)
    {
        this.tileEntity = entityOilPress;
        this.addSlotToContainer(new Slot(tileEntity, 0, 56, 17));
        this.addSlotToContainer(new Slot(tileEntity, 1, 56, 53));
        this.addSlotToContainer(new SlotFurnace(invPlayer.player,tileEntity,2,116,35));
        int i;
        for ( i = 0; i < 3; i++)
        {
            for(int j = 0; j < 9; j++)
            {
                this.addSlotToContainer(new Slot(invPlayer,j+i*9+9,8+j*18,84+i*18));
            }
        }
        for ( i = 0; i < 9; i++)
        {
            this.addSlotToContainer(new Slot(invPlayer, i, 8+i*18,142));
        }
    }

    public void addCraftingToCrafters(ICrafting crafting)
    {
        super.addCraftingToCrafters(crafting);
        crafting.sendProgressBarUpdate(this, 0, this.tileEntity.furnaceCookTime);
        crafting.sendProgressBarUpdate(this, 1, this.tileEntity.furnaceBurnTime);
        crafting.sendProgressBarUpdate(this, 2, this.tileEntity.currentBurnTime);

    }

    public void detectAndSendChanges()
    {
        super.detectAndSendChanges();
        for(int i = 0; i < this.crafters.size(); i++)
        {
            ICrafting craft = (ICrafting) this.crafters.get(i);
            if(this.lastCookTime != this.tileEntity.furnaceCookTime)
            {
                craft.sendProgressBarUpdate(this,0,this.tileEntity.furnaceCookTime);
            }
            if(this.lastBurnTime != this.tileEntity.furnaceBurnTime)
            {
                craft.sendProgressBarUpdate(this,1,this.tileEntity.furnaceBurnTime);
            }

            if(this.lastItemBurnTime != this.tileEntity.currentBurnTime)
            {
                craft.sendProgressBarUpdate(this,2,this.tileEntity.currentBurnTime);
            }

        }

        this.lastBurnTime = this.tileEntity.furnaceBurnTime;
        this.lastCookTime = this.tileEntity.furnaceCookTime;
        this.lastItemBurnTime = this.tileEntity.currentBurnTime;
    }

    @SideOnly(Side.CLIENT)
    public void updateProgressBar(int par1, int par2)
    {

        if(par1 == 0)
        {
            this.tileEntity.furnaceCookTime = par2;
        }

        if(par1 == 1)
        {
            this.tileEntity.furnaceBurnTime = par2;
        }

        if(par1 == 2)
        {
            this.tileEntity.currentBurnTime = par2;
        }


    }

    @Override
    public boolean canInteractWith(EntityPlayer player) {
        return this.tileEntity.isUseableByPlayer(player);
    }

    public ItemStack transferStackInSlot(EntityPlayer player, int par2)
    {
        ItemStack itemStack = null;
        Slot slot = (Slot) this.inventorySlots.get(par2);
        if(slot != null && slot.getHasStack())
        {
            ItemStack itemStack1 = slot.getStack();
            itemStack = itemStack1.copy();
            if(par2 == 2)
            {
                if(!this.mergeItemStack(itemStack1,3,39,true)){
                    return null;
                }
                slot.onSlotChange(itemStack1,itemStack);

            }else if(par2 != 1 && par2 != 0)
            {
                if(OilPressRecipes.smelting().getSmeltingResult(itemStack1) != null)
                {
                    if(!this.mergeItemStack(itemStack1,0,1,false)){
                        return null;
                    }
                }
            }else if(TileEntityOilPress.isItemFuel(itemStack1))
            {
                if(!this.mergeItemStack(itemStack1,1,2,false)){
                    return null;
                }
            }else if(par2 >=3 && par2 < 30)
            {
                if(!this.mergeItemStack(itemStack1,30,39,false))
                {
                    return null;
                }else if(par2 >= 30 && par2 < 39 && !this.mergeItemStack(itemStack1,3,30,false))
                {
                    return null;
                }
            }else if(!this.mergeItemStack(itemStack1, 3, 39, false)){
                return null;
            }
            if(itemStack1.stackSize == 0)
            {
                slot.putStack((ItemStack) null);
            }else{
                slot.onSlotChanged();
            }
            if(itemStack1.stackSize == itemStack.stackSize)
            {
                return null;
            }
            slot.onPickupFromSlot(player, itemStack1);
        }
        return itemStack;
    }
}
