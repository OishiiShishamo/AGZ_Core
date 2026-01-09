package agz_core.common.blocks;

import agz_core.api.blocks.IBlockRegisterEvent;
import agz_core.common.blocks.ZenithCatalystBlock;
import agz_core.common.blocks.machines.ore_replicator.ZenithOreReplicator;
import net.minecraft.block.Block;

import java.util.ArrayList;
import java.util.List;

public class AGZBlocks {
    public static final List<IBlockRegisterEvent> Blocks = new ArrayList<IBlockRegisterEvent>();

    // MatBlocks
    public static final Block ZENITH_CATALYST_BLOCK = new ZenithCatalystBlock("zenith_catalyst_block");

    // OreReplicators
    public static final Block ZENITH_ORE_REPLICATOR = new ZenithOreReplicator("zenith_ore_replicator");
}
