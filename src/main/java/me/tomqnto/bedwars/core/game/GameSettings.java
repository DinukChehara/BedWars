package me.tomqnto.bedwars.core.game;

import lombok.Getter;
import me.tomqnto.bedwars.api.game.GameMode;
import me.tomqnto.bedwars.api.game.Settings;

@Getter
public class GameSettings implements Settings {

    private final GameMode mode;
    private final int maxPlayersPerTeam;
    private final int teamCount;
    private final int maxPlayers;

    public GameSettings(GameMode mode, int playersPerTeam, int teamCount) {
        this.mode = mode;
        this.maxPlayersPerTeam = playersPerTeam;
        this.teamCount = teamCount;
        this.maxPlayers = teamCount * playersPerTeam;
    }
}
