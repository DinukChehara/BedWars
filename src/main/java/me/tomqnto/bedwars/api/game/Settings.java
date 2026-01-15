package me.tomqnto.bedwars.api.game;

public interface Settings {

    /**
     * @return the maximum number of players allowed in the arena
     */
    int getMaxPlayers();

    /**
     * @return the maximum number of players allowed per team
     */
    int getMaxPlayersPerTeam();

}
