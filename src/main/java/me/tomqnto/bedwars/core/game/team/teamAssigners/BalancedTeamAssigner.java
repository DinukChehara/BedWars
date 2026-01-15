package me.tomqnto.bedwars.core.game.team.teamAssigners;

import me.tomqnto.bedwars.api.game.team.ITeam;
import me.tomqnto.bedwars.api.game.team.TeamAssigner;

import java.util.Collection;
import java.util.UUID;

public class BalancedTeamAssigner implements TeamAssigner {
    @Override
    public ITeam assign(UUID player, Collection<ITeam> teams) {
        ITeam best = null;

        for (ITeam team : teams) {
            if (!team.canJoin()) continue;

            if (best == null || team.getPlayerCount() < best.getPlayerCount())
                best = team;
        }
        if (best == null) return null;

        best.addPlayer(player);
        return best;
    }
}
