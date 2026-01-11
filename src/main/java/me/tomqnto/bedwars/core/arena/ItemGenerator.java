package me.tomqnto.bedwars.core.arena;

import com.sun.istack.internal.Nullable;
import me.tomqnto.bedwars.api.arena.Arena;
import me.tomqnto.bedwars.api.arena.generator.Generator;
import me.tomqnto.bedwars.api.arena.generator.GeneratorType;
import me.tomqnto.bedwars.api.arena.team.Team;
import me.tomqnto.bedwars.api.region.Cuboid;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class ItemGenerator implements Generator {

    private final Location location;
    private final GeneratorType type;
    private final Arena arena;
    private final Team team;

    private ItemStack item = new ItemStack(Material.DIAMOND);

    public ItemGenerator(Location location, GeneratorType type, Arena arena, @Nullable Team team) {
        this.location = location;
        this.type = type;
        this.arena = arena;
        this.team = team;

        Cuboid c = new Cuboid(location, 3, true);
        c.setMaxY(c.getMaxY() + 5);
        c.setMinY(c.getMaxY() - 2);
        arena.getRegions().add(c);
    }

    @Override
    public boolean create(Location location) {
        return false;
    }

    @Override
    public GeneratorType getType() {
        return type;
    }

    @Override
    public boolean spawn() {
        return false;
    }

    @Override
    public void setItem(ItemStack item) {
        this.item = item;
    }

    @Override
    public Arena getArena() {
        return arena;
    }

    @Override
    public void rotate() {

    }

    @Override
    public void setInterval(long delayTicks) {

    }

    @Override
    public void setAmount(int amount) {
        this.item.setAmount(amount);
    }

    @Override
    public Location getLocation() {
        return location.clone();
    }

    @Override
    public ItemStack getItem() {
        return item.clone();
    }

    @Override
    public void setCapacity(int value) {

    }

    @Override
    public void updateHologram() {

    }

    @Override
    public void rotate(boolean b) {

    }

    @Override
    @Nullable public Team getTeam() {
        return team;
    }

    @Override
    public void spawnHolograms() {

    }
}
