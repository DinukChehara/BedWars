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

    @Override
    public long getGlobalGeneratorIntervalTicks(GeneratorType generatorType) {
        switch (generatorType) {
            case DIAMOND:
                return 0;

            case EMERALD:
                return 1;

            default:
                throw new IllegalArgumentException(
                        "Generator type " + generatorType + " is not a global generator (expected DIAMOND or EMERALD)"
                );
        }
    }
}
