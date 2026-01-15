package me.tomqnto.bedwars.api.game;

import lombok.Getter;

@Getter
public enum GameMode {
    SOLOS(1, 8),
    DUOS(2, 8),
    TRIOS(3, 4),
    QUADS(4, 4);

    private final int playersPerTeam;
    private final int teamCount;

    GameMode(int playersPerTeam, int teamCount) {
        this.playersPerTeam = playersPerTeam;
        this.teamCount = teamCount;
    }
}
