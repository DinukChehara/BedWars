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

}
