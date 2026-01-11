package me.tomqnto.bedwars.core.arena.generators;

import me.tomqnto.bedwars.api.arena.Arena;
import me.tomqnto.bedwars.api.arena.generator.Generator;
import me.tomqnto.bedwars.api.arena.generator.GeneratorType;
import me.tomqnto.bedwars.api.arena.team.Team;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class DiamondGenerator implements Generator {

    private final GeneratorType type = GeneratorType.DIAMOND;
    private ItemStack item = new ItemStack(Material.DIAMOND);

    private final Arena arena;

    public DiamondGenerator(Arena arena) {
        this.arena = arena;
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
        return null;
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
    public Team getTeam() {
        return null;
    }

    @Override
    public void spawnHolograms() {

    }
}
