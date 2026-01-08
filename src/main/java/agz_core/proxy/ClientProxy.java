package agz_core.proxy;

import agz_core.common.blocks.AGZBlocks;
import agz_core.common.items.AGZItems;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class ClientProxy extends CommonProxy {
    //Logger logger;
    @Override
    public void preInit(FMLPreInitializationEvent event) {
        super.preInit(event);
    }

    @SubscribeEvent
    public void registerModels(ModelRegistryEvent event) {
        AGZItems.Items.forEach(item -> item.registerModel(event));
        AGZBlocks.Blocks.forEach(block -> block.registerModel(event));
    }
}
