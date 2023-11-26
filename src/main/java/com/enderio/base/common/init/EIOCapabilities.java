package com.enderio.base.common.init;

import com.enderio.EnderIO;
import com.enderio.api.capability.ICoordinateSelectionHolder;
import com.enderio.api.capability.IDarkSteelUpgradable;
import com.enderio.api.capability.IEntityStorage;
import com.enderio.api.capability.IOwner;
import com.enderio.api.capability.ISideConfig;
import com.enderio.api.capability.IToggled;
import com.enderio.api.capacitor.ICapacitorData;
import net.neoforged.neoforge.common.capabilities.Capability;
import net.neoforged.neoforge.common.capabilities.CapabilityManager;
import net.neoforged.neoforge.common.capabilities.CapabilityToken;
import net.neoforged.neoforge.common.capabilities.RegisterCapabilitiesEvent;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;

@Mod.EventBusSubscriber(modid = EnderIO.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class EIOCapabilities {
    public static final Capability<IEntityStorage> ENTITY_STORAGE = CapabilityManager.get(new CapabilityToken<>() {});

    public static final Capability<IToggled> TOGGLED = CapabilityManager.get(new CapabilityToken<>() {});

    public static final Capability<IOwner> OWNER = CapabilityManager.get(new CapabilityToken<>() {});

    public static final Capability<ICapacitorData> CAPACITOR = CapabilityManager.get(new CapabilityToken<>() {});

    public static final Capability<ICoordinateSelectionHolder> COORDINATE_SELECTION_HOLDER = CapabilityManager.get(new CapabilityToken<>() {});

    public static final Capability<IDarkSteelUpgradable> DARK_STEEL_UPGRADABLE = CapabilityManager.get(new CapabilityToken<>() {});

    public static final Capability<ISideConfig> SIDE_CONFIG = CapabilityManager.get(new CapabilityToken<>() {});

    @SubscribeEvent
    public static void register(RegisterCapabilitiesEvent event) {
        event.register(IEntityStorage.class);
        event.register(IToggled.class);
        event.register(IOwner.class);
        event.register(ICapacitorData.class);
        event.register(IDarkSteelUpgradable.class);
        event.register(ICoordinateSelectionHolder.class);
        event.register(ISideConfig.class);
    }
}
