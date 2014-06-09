package resonant.core.content.debug;

import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ChatMessageComponent;
import resonant.lib.content.module.prefab.TileInventory;
import resonant.lib.multiblock.IBlockActivate;

public class TileInfiniteItem extends TileInventory implements IBlockActivate {

	ItemStack refStack = null;
	
	public TileInfiniteItem() {
		super(Material.rock);
		
	}
	
	@Override
	public void updateEntity () {
		super.updateEntity();
		if (refStack != null)
			
			this.setInventorySlotContents(0, refStack.copy());
		
	}
		
    @Override
    public boolean onActivated(EntityPlayer entityPlayer)
    {
        if (entityPlayer != null && entityPlayer.getHeldItem() != null){
           	   		refStack = entityPlayer.getHeldItem().copy();
        	   		refStack.stackSize = 64;
        	   		if (!worldObj.isRemote){
        	   		entityPlayer.sendChatToPlayer(ChatMessageComponent.createFromText("[ItemStack]Item:" + refStack.getItem().getUnlocalizedName()));}
					
        	   	return true;

        }
        return false;        
    }
    
    @Override
    public void writeToNBT(NBTTagCompound compound) {
    	super.writeToNBT(compound);
    	NBTTagCompound itemstack = new NBTTagCompound();
    	if (refStack != null){refStack.writeToNBT(itemstack);
    	compound.setCompoundTag("itemstack", itemstack);
    	}
    	
    }
    
    @Override
    public void readFromNBT(NBTTagCompound compound) {
    	super.readFromNBT(compound);
    	
    	if (compound.hasKey("itemstack"))
    	refStack = ItemStack.loadItemStackFromNBT(compound.getCompoundTag("itemstack"));
    	
    	
    }
}
