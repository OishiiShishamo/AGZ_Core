package agz_core.common.blocks;

import agz_core.api.blocks.IBlockRegisterEvent;
import agz_core.common.blocks.machines.OreReplicator;
import agz_core.common.tile.machines.ore_replicator.TileOreReplicator;
import net.minecraft.block.Block;

import java.util.ArrayList;
import java.util.List;

public class AGZBlocks {
    public static final List<IBlockRegisterEvent> Blocks = new ArrayList<IBlockRegisterEvent>();

    // MatBlocks
    public static final Block ZENITH_CATALYST_BLOCK = new ZenithCatalystBlock("zenith_catalyst_block");

    // OreReplicators
    public static final Block STEAM_ORE_REPLICATOR  = new OreReplicator("steam_ore_replicator",  TileOreReplicator.tiers.STEAM);
    public static final Block LV_ORE_REPLICATOR     = new OreReplicator("lv_ore_replicator",     TileOreReplicator.tiers.LV);
    public static final Block MV_ORE_REPLICATOR     = new OreReplicator("mv_ore_replicator",     TileOreReplicator.tiers.MV);
    public static final Block HV_ORE_REPLICATOR     = new OreReplicator("hv_ore_replicator",     TileOreReplicator.tiers.HV);
    public static final Block EV_ORE_REPLICATOR     = new OreReplicator("ev_ore_replicator",     TileOreReplicator.tiers.EV);
    public static final Block IV_ORE_REPLICATOR     = new OreReplicator("iv_ore_replicator",     TileOreReplicator.tiers.IV);
    public static final Block LUV_ORE_REPLICATOR    = new OreReplicator("luv_ore_replicator",    TileOreReplicator.tiers.LuV);
    public static final Block ZPM_ORE_REPLICATOR    = new OreReplicator("zpm_ore_replicator",    TileOreReplicator.tiers.ZPM);
    public static final Block UV_ORE_REPLICATOR     = new OreReplicator("uv_ore_replicator",     TileOreReplicator.tiers.UV);
    public static final Block UHV_ORE_REPLICATOR    = new OreReplicator("uhv_ore_replicator",    TileOreReplicator.tiers.UHV);
    public static final Block ZENITH_ORE_REPLICATOR = new OreReplicator("zenith_ore_replicator", TileOreReplicator.tiers.Zenith);
}
