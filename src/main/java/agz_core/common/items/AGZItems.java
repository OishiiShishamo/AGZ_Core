package agz_core.common.items;

import agz_core.api.items.IItemRegisterEvent;
import net.minecraft.item.Item;

import java.util.ArrayList;
import java.util.List;

import net.minecraftforge.event.RegistryEvent;

public class AGZItems {
    public static final List<IItemRegisterEvent> Items = new ArrayList<IItemRegisterEvent>();

    // MatItems
    public static final Item ZENITH_CATALYST = new ZenithCatalyst("zenith_catalyst");
}
