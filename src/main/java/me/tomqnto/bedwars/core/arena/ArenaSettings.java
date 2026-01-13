package me.tomqnto.bedwars.core.arena;

import lombok.Getter;
import me.tomqnto.bedwars.api.arena.GameMode;

@Getter
public class ArenaSettings {

    private final GameMode mode;
    private final int playersPerTeam;
    private final int teamCount;
    private final int maxPlayers;

    public ArenaSettings(GameMode mode, int playersPerTeam, int teamCount) {
        this.mode = mode;
        this.playersPerTeam = playersPerTeam;
        this.teamCount = teamCount;
        this.maxPlayers = teamCount * playersPerTeam;
    }
}
