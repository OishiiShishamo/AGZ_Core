package agz_core.common.blocks;

import agz_core.api.blocks.IBlockRegisterEvent;
import agz_core.common.blocks.ZenithCatalystBlock;
import net.minecraft.block.Block;

import java.util.ArrayList;
import java.util.List;

public class AGZBlocks {
    public static final List<IBlockRegisterEvent> Blocks = new ArrayList<IBlockRegisterEvent>();

    public static final Block ZENITH_CATALYST_BLOCK = new ZenithCatalystBlock("zenith_catalyst_block");
}
