package agz_core.proxy;

import agz_core.Tags;
import agz_core.common.blocks.AGZBlocks;
import agz_core.common.items.AGZItems;
import agz_core.common.tile.machines.ore_replicator.TileOreReplicator;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLInterModComms;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod.EventBusSubscriber(modid = Tags.MODID)
public abstract class CommonProxy {
    public static final Logger LOGGER = LogManager.getLogger(Tags.MODID);

    public void preInit(FMLPreInitializationEvent event) {
        LOGGER.info("I am " + Tags.MODNAME + " + at version " + Tags.VERSION);
        GameRegistry.registerTileEntity(
                TileOreReplicator.class,
                new ResourceLocation(Tags.MODID, "ore_replicator")
        );
    }

    public void init(FMLInitializationEvent event) {
        FMLInterModComms.sendFunctionMessage(
                "theoneprobe",
                "getTheOneProbe",
                "agz_core.api.integration.top.TOPIntegration"
        );

        OreDictionary.registerOre("catalystZenith", AGZItems.ZENITH_CATALYST);
    }

    public void postInit(FMLPostInitializationEvent event) {
    }

    @SubscribeEvent
    public void registerRecipes(RegistryEvent.Register<IRecipe> event) {

    }

    @SubscribeEvent
    public void registerItems(RegistryEvent.Register<Item> event) {
        AGZItems.Items.forEach(item -> item.registerItem(event));
        AGZBlocks.Blocks.forEach(block -> block.registerItemBlock(event));
    }

    @SubscribeEvent
    public void registerBlocks(RegistryEvent.Register<Block> event) {
        AGZBlocks.Blocks.forEach(block -> block.registerBlock(event));
    }
}
