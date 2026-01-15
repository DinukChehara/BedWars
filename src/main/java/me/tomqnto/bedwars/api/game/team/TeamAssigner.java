package me.tomqnto.bedwars.api.game.team;

import java.util.Collection;
import java.util.UUID;

public interface TeamAssigner {

    /**
     *
     * @param player The player needs to be added to a team
     * @param teams The list of teams in the game
     * @return The team the player is assigned to
     */
    ITeam assign(UUID player, Collection<ITeam> teams);
}
