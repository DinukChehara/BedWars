package me.tomqnto.bedwars.api.arena.team;

import java.util.Collection;
import java.util.UUID;

public interface TeamAssigner {

    /**
     *
     * @param player The player needs to be added to a team
     * @param teams The list of teams in the game
     * @return The team the player is assigned to
     */
    Team assign(UUID player, Collection<Team> teams);
}
