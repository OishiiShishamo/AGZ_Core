package agz_core.api.integration.top;

import agz_core.common.tile.machines.ore_replicator.TileOreReplicator;
import mcjty.theoneprobe.api.IProbeHitData;
import mcjty.theoneprobe.api.IProbeInfo;
import mcjty.theoneprobe.api.IProbeInfoProvider;
import mcjty.theoneprobe.api.ProbeMode;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class OreReplicatorTOPProvider implements IProbeInfoProvider {
    @Override
    public String getID() {
        return "agz_core:ore_replicator";
    }

    @Override
    public void addProbeInfo(
            ProbeMode mode,
            IProbeInfo probeInfo,
            EntityPlayer player,
            World world,
            IBlockState state,
            IProbeHitData data
    ) {
        TileEntity te = world.getTileEntity(data.getPos());
        if (!(te instanceof TileOreReplicator)) {
            return;
        }

        TileOreReplicator replicator = (TileOreReplicator) te;

        ItemStack stack = replicator.getStoredStack();
        if (!stack.isEmpty()) {
            probeInfo
                    .horizontal()
                    .item(stack)
                    .text(stack.getDisplayName());
            probeInfo.progress(
                    replicator.getProgress(),
                    replicator.getMaxProgress()
            );
            probeInfo.text("Num: " + replicator.getNum());
        } else {
            probeInfo.text("No item stored");
        }
    }
}