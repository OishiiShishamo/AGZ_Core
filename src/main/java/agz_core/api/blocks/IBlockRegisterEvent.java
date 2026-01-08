package agz_core.api.blocks;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;

public interface IBlockRegisterEvent {
    void registerBlock(RegistryEvent.Register<Block> event);
    void registerItemBlock(RegistryEvent.Register<Item> event);
    void registerModel(ModelRegistryEvent event);
}
