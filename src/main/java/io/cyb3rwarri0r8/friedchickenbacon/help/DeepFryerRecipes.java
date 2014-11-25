package io.cyb3rwarri0r8.friedchickenbacon.help;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by noah on 10/7/14.
 */
public class DeepFryerRecipes {

    private static final DeepFryerRecipes recipesBase = new DeepFryerRecipes();

    private Map smeltingList = new HashMap();
    private Map xpList = new HashMap();

    private DeepFryerRecipes()
    {

    }

    public static DeepFryerRecipes smelting()
    {
        return recipesBase;
    }

    public void lists(ItemStack itemStack, ItemStack itemStack1, float xp)
    {
        this.getSmeltingList().put(itemStack, itemStack1);
        xpList.put(itemStack1, Float.valueOf(xp));
    }

    public void addLists(Item item, ItemStack itemStack, float xp)
    {
        this.lists(new ItemStack(item, 1, 32767), itemStack, xp);
    }

    public void addRecipe(Item item, ItemStack itemStack, float xp)
    {
        this.addLists(item, itemStack, xp);
    }

    public ItemStack getSmeltingResult(ItemStack p_151395_1_)
    {
        Iterator iterator = this.smeltingList.entrySet().iterator();
        Map.Entry entry;

        do
        {
            if (!iterator.hasNext())
            {
                return null;
            }

            entry = (Map.Entry)iterator.next();
        }
        while (!this.canBeSmelted(p_151395_1_, (ItemStack) entry.getKey()));

        return (ItemStack)entry.getValue();
    }

    private boolean canBeSmelted(ItemStack itemStack, ItemStack itemStack1)
    {
        return itemStack1.getItem() == itemStack.getItem() && (itemStack1.getItemDamage() == 32767 || itemStack.getItemDamage() == itemStack.getItemDamage());
    }

    public Map getSmeltingList()
    {
        return this.smeltingList;
    }

    public float giveXP(ItemStack p_151398_1_)
    {
        float ret = p_151398_1_.getItem().getSmeltingExperience(p_151398_1_);
        if (ret != -1) return ret;

        Iterator iterator = this.xpList.entrySet().iterator();
        Map.Entry entry;

        do
        {
            if (!iterator.hasNext())
            {
                return 0.0F;
            }

            entry = (Map.Entry)iterator.next();
        }
        while (!this.canBeSmelted(p_151398_1_, (ItemStack) entry.getKey()));

        return ((Float)entry.getValue()).floatValue();
    }

}
