package me.tomqnto.bedwars.core.arena.team.teamAssigners;

import me.tomqnto.bedwars.api.arena.team.Team;
import me.tomqnto.bedwars.api.arena.team.TeamAssigner;

import java.util.Collection;
import java.util.UUID;

public class FillFirstTeamAssigner  implements TeamAssigner {

    @Override
    public Team assign(UUID player, Collection<Team> teams) {
        for (Team team : teams) {
            if (team.canJoin()) {
                team.addPlayer(player);
                return team;
            }
        }
        return null;
    }
}
