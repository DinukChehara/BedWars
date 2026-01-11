package me.tomqnto.bedwars.core.arena.team.teamAssigners;

import me.tomqnto.bedwars.api.arena.team.Team;
import me.tomqnto.bedwars.api.arena.team.TeamAssigner;

import java.util.Collection;
import java.util.UUID;

public class BalancedTeamAssigner implements TeamAssigner {
    @Override
    public Team assign(UUID player, Collection<Team> teams) {
        Team best = null;

        for (Team team : teams) {
            if (!team.canJoin()) continue;

            if (best == null || team.getPlayerCount() < best.getPlayerCount())
                best = team;
        }
        if (best == null) return null;

        best.addPlayer(player);
        return best;
    }
}
