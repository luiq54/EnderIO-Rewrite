package com.enderio.conduits.common.blockentity;

import com.enderio.EnderIO;
import com.enderio.api.conduit.IConduitType;
import net.minecraft.resources.ResourceLocation;

public enum ConduitType implements IConduitType {
    POWER(EnderIO.loc("block/conduit/power"));


    private final ResourceLocation texture;
    private final int activeLightLevel;

    ConduitType(ResourceLocation texture) {
        this(texture, 0);
    }

    ConduitType(ResourceLocation texture, int activeLightLevel) {
        this.texture = texture;
        this.activeLightLevel = activeLightLevel;
    }
    @Override
    public ResourceLocation getTexture() {
        return texture;
    }

    @Override
    public int getLightLevel(boolean isActive) {
        return isActive ? activeLightLevel : 0;
    }
}
