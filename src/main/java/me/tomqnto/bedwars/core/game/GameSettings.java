package me.tomqnto.bedwars.core.game;

import lombok.Getter;
import me.tomqnto.bedwars.api.game.GameMode;

@Getter
public class GameSettings {

    private final GameMode mode;
    private final int playersPerTeam;
    private final int teamCount;
    private final int maxPlayers;

    public GameSettings(GameMode mode, int playersPerTeam, int teamCount) {
        this.mode = mode;
        this.playersPerTeam = playersPerTeam;
        this.teamCount = teamCount;
        this.maxPlayers = teamCount * playersPerTeam;
    }
}
