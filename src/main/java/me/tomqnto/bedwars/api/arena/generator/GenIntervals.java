package me.tomqnto.bedwars.api.arena.generator;

import lombok.Getter;

@Getter
public enum GenIntervals {

    DIAMOND_I(30), DIAMOND_II(25), DIAMOND_III(15),
    EMERALD_I(60), EMERALD_II(40), EMERALD_III(25);

    private final long interval;

    GenIntervals(long interval) {
        this.interval = interval;
    }
}
