package me.tomqnto.bedwars.core.arena.gens;

import me.tomqnto.bedwars.api.arena.Arena;
import me.tomqnto.bedwars.api.arena.generator.GeneratorType;
import me.tomqnto.bedwars.api.arena.team.Team;
import me.tomqnto.bedwars.core.arena.ItemGenerator;
import org.bukkit.Location;

public class IronGenerator extends ItemGenerator {

    public IronGenerator(Location location, Arena arena, Team team) {
        super(location, GeneratorType.IRON, arena, team, 2);
    }
}
