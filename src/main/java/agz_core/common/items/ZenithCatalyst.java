package agz_core.common.items;

import agz_core.Tags;
import agz_core.api.items.IItemRegisterEvent;
import agz_core.common.creative_tabs.AGZCreativeTabs;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;

public class ZenithCatalyst extends Item implements IItemRegisterEvent {

    private final String name;

    public ZenithCatalyst(String name) {
        super();
        this.name = name;
        this.setRegistryName(Tags.MODID, this.name);
        this.setCreativeTab(AGZCreativeTabs.TAB_AGZ);
        this.setTranslationKey(this.name);

        AGZItems.Items.add(this);
    }

    @Override
    public void registerItem(RegistryEvent.Register<Item> event) {
        event.getRegistry().register(this);
    }

    public void registerModel(ModelRegistryEvent event) {
        ModelLoader.setCustomModelResourceLocation(this, 0,
                new ModelResourceLocation(new ResourceLocation(Tags.MODID, this.name), "inventory"));
    }
}
