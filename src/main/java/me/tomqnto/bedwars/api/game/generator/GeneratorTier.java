package me.tomqnto.bedwars.api.game.generator;

import lombok.Getter;

@Getter
public enum GeneratorTier {
    IRON_I(1, -1, -1), IRON_II(2, -1, -1), IRON_III(3, -1, -1),
    GOLD_I(1, -1, -1), GOLD_II(2, -1, -1), GOLD_III(3, -1, -1),
    DIAMOND_I(1, 30, 4), DIAMOND_II(2, 25, 8), DIAMOND_III(3, 15, 2),
    EMERALD_I(1, 60, 2), EMERALD_II(2, 40, 3), EMERALD_III(3, 25, 3);

    private final int tier;
    private final long interval;
    private final int capacity;

    GeneratorTier(int tier, long interval, int capacity) {
        this.tier = tier;
        this.interval = interval;
        this.capacity = capacity;
    }
}
