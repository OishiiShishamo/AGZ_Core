package agz_core.common.creative_tabs;

import gregtech.api.creativetab.BaseCreativeTab;

import agz_core.Tags;
import agz_core.common.items.AGZItems;
import net.minecraft.item.ItemStack;

public class AGZCreativeTabs {
    public static final BaseCreativeTab TAB_AGZ = new BaseCreativeTab(Tags.MODID + ".main",
            () -> new ItemStack(AGZItems.ZENITH_CATALYST), false);

    private AGZCreativeTabs() {}
}
