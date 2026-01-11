package me.tomqnto.bedwars.api.arena;

public enum GameMode {
    SOLOS(1), DUOS(2), TRIOS(3), QUADS(4), CUSTOM(-1);

    private final int playersPerTeam;

    GameMode(int playersPerTeam) {
        this.playersPerTeam = playersPerTeam;
    }

    public int getPlayersPerTeam() {
        return playersPerTeam;
    }

    public boolean isCustom() {
        return this == CUSTOM;
    }
}
