package agz_core.api.integration.top;

import mcjty.theoneprobe.api.ITheOneProbe;

import java.util.function.Function;

public class TOPIntegration implements Function<ITheOneProbe, Void> {
    @Override
    public Void apply(ITheOneProbe top) {
        top.registerProvider(new OreReplicatorTOPProvider());
        return null;
    }
}