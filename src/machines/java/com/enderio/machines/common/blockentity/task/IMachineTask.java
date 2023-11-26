package com.enderio.machines.common.blockentity.task;

import net.minecraft.nbt.CompoundTag;
import net.neoforged.neoforge.common.util.INBTSerializable;

public interface IMachineTask extends INBTSerializable<CompoundTag> {
    void tick();

    float getProgress();

    boolean isCompleted();
}
