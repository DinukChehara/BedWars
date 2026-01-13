package me.tomqnto.bedwars.core.arena.gens;

import me.tomqnto.bedwars.api.arena.IArena;
import me.tomqnto.bedwars.api.arena.generator.GeneratorType;
import me.tomqnto.bedwars.api.arena.team.ITeam;
import me.tomqnto.bedwars.core.arena.ItemGenerator;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class IronGenerator extends ItemGenerator {

    public IronGenerator(Location location, IArena arena, ITeam team) {
        super(location, GeneratorType.IRON, arena, team, 2, new ItemStack(Material.IRON_INGOT));
    }
}
