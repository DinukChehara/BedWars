package me.tomqnto.bedwars.api.arena.team;

import java.util.Set;
import java.util.UUID;

public interface ITeam {

    /**
     * @return The bed of the team
     */
    IBed getBed();

    /**
     * @return The number of players in this team
     */
    int getPlayerCount();

    /**
     * @return The maximum number of players that can be in this team
     */
    int getMaxPlayers();

    /**
     * @return A Set of players in this team
     */
    Set<UUID> getPlayers();

    /**
     * Adds a player to the team
     *
     * @return true if player can be added, else false
     */
    boolean addPlayer(UUID player);
}
