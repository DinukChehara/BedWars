package me.tomqnto.bedwars.core.arena.team.settings;

import me.tomqnto.bedwars.api.arena.ArenaSettings;
import me.tomqnto.bedwars.api.arena.generator.GeneratorType;

public class SolosSettings implements ArenaSettings {

    @Override
    public int getMaxPlayers() {
        return 8;
    }

    @Override
    public int getMaxPlayersPerTeam() {
        return 1;
    }

}
