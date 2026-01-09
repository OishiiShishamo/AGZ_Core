package agz_core.common.tile.machines.ore_replicator;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;
import net.minecraft.world.World;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemHandlerHelper;
import net.minecraftforge.oredict.OreDictionary;
import org.jetbrains.annotations.NotNull;

public class TileOreReplicator extends TileEntity implements ITickable {

    private ItemStack storedStack = ItemStack.EMPTY;

    private int progress = 0;
    private int maxProgress = 20;
    private static final int num[] = {1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048, 4096, 8192, 2147483647};

    public static enum tiers {
        STEAM,
        LV,
        MV,
        HV,
        EV,
        IV,
        LuV,
        ZPM,
        UV,
        UHV,
        UEV,
        UIV,
        UMV,
        UXV,
        Zenith
    }

    private tiers tier = tiers.Zenith;

    public void setTier(tiers tier) {
        this.tier = tier;
    }

    @NotNull
    public ItemStack getStoredStack() {
        return storedStack;
    }

    public int getProgress() {
        return progress;
    }

    public int getMaxProgress() {
        return maxProgress;
    }

    public tiers getTier() {
        return tier;
    }

    public int getNum() {
        return num[tier.ordinal()];
    }

    public boolean hasItem() {
        return !storedStack.isEmpty();
    }

    public void setStoredStack(ItemStack stack) {
        if (stack.isEmpty()) return;
        if (!canAccept(stack)) return;
        this.storedStack = stack;
        this.progress = 0;
        markDirty();
    }

    public void clearStoredStack() {
        this.storedStack = ItemStack.EMPTY;
        this.progress = 0;
        markDirty();
    }

    @NotNull
    public boolean canAccept(ItemStack stack) {
        if (stack.isEmpty()) return false;

        int[] ids = OreDictionary.getOreIDs(stack);
        for (int id : ids) {
            String name = OreDictionary.getOreName(id);
            if (name.startsWith("ore")) {
                return true;
            }
        }
        return false;
    }

    public void terminate() {
        TileEntity aboveTile = world.getTileEntity(getPos().up());
        if (aboveTile == null) return;
        IItemHandler handler = aboveTile.getCapability(
                CapabilityItemHandler.ITEM_HANDLER_CAPABILITY,
                EnumFacing.DOWN
        );
        if (handler == null) return;
        ItemStack remaining = storedStack.copy();
        remaining.setCount(getNum());
        ItemHandlerHelper.insertItem(handler, remaining, false);
        return;
    }

    @Override
    public void update() {
        if (world == null || world.isRemote) return;

        if (!hasItem()) {
            progress = 0;
            return;
        }

        progress++;

        if (progress >= maxProgress) {
            terminate();
            progress = 0;
        }
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound compound) {
        super.writeToNBT(compound);

        if (!storedStack.isEmpty()) {
            NBTTagCompound itemTag = new NBTTagCompound();
            storedStack.writeToNBT(itemTag);
            compound.setTag("StoredItem", itemTag);
        }

        compound.setInteger("Progress", progress);
        compound.setInteger("MaxProgress", maxProgress);
        compound.setInteger("Tier", tier.ordinal());

        return compound;
    }

    @Override
    public void readFromNBT(NBTTagCompound compound) {
        super.readFromNBT(compound);

        if (compound.hasKey("StoredItem")) {
            storedStack = new ItemStack(compound.getCompoundTag("StoredItem"));
        } else {
            storedStack = ItemStack.EMPTY;
        }

        int t = compound.getInteger("Tier");
        tier = tiers.values()[t];
        progress = compound.getInteger("Progress");
        maxProgress = compound.getInteger("MaxProgress");
    }
}