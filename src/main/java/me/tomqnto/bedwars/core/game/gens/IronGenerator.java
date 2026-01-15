package me.tomqnto.bedwars.core.game.gens;

import me.tomqnto.bedwars.api.game.IGame;
import me.tomqnto.bedwars.api.game.generator.GeneratorType;
import me.tomqnto.bedwars.api.game.team.ITeam;
import me.tomqnto.bedwars.core.game.ItemGenerator;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class IronGenerator extends ItemGenerator {

    public IronGenerator(Location location, IGame arena, ITeam team) {
        super(location, GeneratorType.IRON, arena, team, 2, new ItemStack(Material.IRON_INGOT));
    }
}
