package agz_core.common.blocks;

import agz_core.Tags;
import agz_core.api.blocks.IBlockRegisterEvent;
import agz_core.common.creative_tabs.AGZCreativeTabs;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;

public class ZenithCatalystBlock extends Block implements IBlockRegisterEvent {
    protected final String Name;

    public ZenithCatalystBlock(String name) {
        super(Material.IRON);
        this.Name = name;
        this.setRegistryName(Tags.MODID, this.Name);
        this.setCreativeTab(AGZCreativeTabs.TAB_AGZ);
        this.setTranslationKey(this.Name);

        AGZBlocks.Blocks.add(this);
    }


    @Override
    public void registerBlock(RegistryEvent.Register<Block> event) {
        event.getRegistry().register(this);
    }

    @Override
    public void registerItemBlock(RegistryEvent.Register<Item> event) {
        event.getRegistry().register(new ItemBlock(this).setRegistryName(Tags.MODID, this.Name));
    }

    @Override
    public void registerModel(ModelRegistryEvent event) {
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(this), 0,
                new ModelResourceLocation(new ResourceLocation(Tags.MODID, this.Name), "inventory"));
    }
}
