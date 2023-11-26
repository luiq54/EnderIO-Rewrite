package com.enderio.api.capacitor;

import net.neoforged.neoforge.common.util.NonNullSupplier;

import java.util.function.Supplier;

/**
 * A value that is scaled linearly.
 * (base, level) => base * level
 */
public record LinearScalable(CapacitorModifier modifier, Supplier<Integer> base) implements ICapacitorScalable {

    @Override
    public Supplier<Float> scaleF(NonNullSupplier<ICapacitorData> data) {
        return () -> scale(base.get(), data.get().getModifier(modifier));
    }

    @Override
    public Supplier<Integer> scaleI(NonNullSupplier<ICapacitorData> data) {
        return () -> Math.round(scale(base.get(), data.get().getModifier(modifier)));
    }

    private static float scale(int base, float level) {
        return base * level;
    }
}
