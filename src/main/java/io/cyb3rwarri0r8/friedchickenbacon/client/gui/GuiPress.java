package io.cyb3rwarri0r8.friedchickenbacon.client.gui;

import io.cyb3rwarri0r8.friedchickenbacon.client.container.ContainerOilPress;
import io.cyb3rwarri0r8.friedchickenbacon.help.Reference;
import io.cyb3rwarri0r8.friedchickenbacon.tileentity.TileEntityOilPress;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

/**
 * Created by noah on 10/13/14.
 */
public class GuiPress extends GuiContainer {
    private static final ResourceLocation fryerGuiTextures = new ResourceLocation(Reference.MODID + ":" + "textures/gui/container/press.png");
    private TileEntityOilPress entityOilPress;



    public GuiPress(InventoryPlayer invPlayer, TileEntityOilPress entityOilPress) {
        super(new ContainerOilPress(invPlayer, entityOilPress));
        this.entityOilPress = entityOilPress;
    }

    /**
     * Draw the foreground layer for the GuiContainer (everything in front of the items)
     */
    protected void drawGuiContainerForegroundLayer(int p_146979_1_, int p_146979_2_)
    {
        String s = this.entityOilPress.hasCustomInventoryName() ? this.entityOilPress.getInventoryName() : I18n.format(this.entityOilPress.getInventoryName(), new Object[0]);
        this.fontRendererObj.drawString(s, this.xSize / 2 - this.fontRendererObj.getStringWidth(s) / 2, 6, 4210752);
        this.fontRendererObj.drawString(I18n.format("container.inventory", new Object[0]), 8, this.ySize - 96 + 2, 4210752);
    }



    @Override
    protected void drawGuiContainerBackgroundLayer(float p_146976_1_, int p_146976_2_, int p_146976_3_)
    {
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.getTextureManager().bindTexture(fryerGuiTextures);
        int k = (this.width - this.xSize) / 2;
        int l = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(k, l, 0, 0, this.xSize, this.ySize);
        int i1;
        if (this.entityOilPress.isBurning())
        {
            i1 = this.entityOilPress.getBurnTimeRemainingScaled(12);
            this.drawTexturedModalRect(k + 56, l + 36 + 12 - i1, 176, 12 - i1, 14, i1 + 1);

        }
        i1 = this.entityOilPress.getCookProgressScaled(24);
        this.drawTexturedModalRect(k + 79, l + 34, 176, 14, i1 + 1, 16);
    }
}
