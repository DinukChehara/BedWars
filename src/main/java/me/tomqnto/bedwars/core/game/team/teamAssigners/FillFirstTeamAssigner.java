package me.tomqnto.bedwars.core.game.team.teamAssigners;

import me.tomqnto.bedwars.api.game.team.ITeam;
import me.tomqnto.bedwars.api.game.team.TeamAssigner;

import java.util.Collection;
import java.util.UUID;

public class FillFirstTeamAssigner  implements TeamAssigner {

    @Override
    public ITeam assign(UUID player, Collection<ITeam> teams) {
        for (ITeam team : teams) {
            if (team.canJoin()) {
                team.addPlayer(player);
                return team;
            }
        }
        return null;
    }
}
