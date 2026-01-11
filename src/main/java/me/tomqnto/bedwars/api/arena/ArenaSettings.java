package me.tomqnto.bedwars.api.arena;

import me.tomqnto.bedwars.api.arena.generator.GeneratorType;

public interface ArenaSettings {

    /**
     * @return the maximum number of players allowed in the arena
     */
    int getMaxPlayers();

    /**
     * @return the maximum number of players allowed per team
     */
    int getMaxPlayersPerTeam();

    /**
     * Returns the spawn interval for the given generator type.
     *
     * @param generatorType the type of generator (only DIAMOND and EMERALD generators)
     * @return the generator spawn interval in ticks
     * @throws IllegalArgumentException if the generator type is not supported
     */
    long getGlobalGeneratorIntervalTicks(GeneratorType generatorType);
}
