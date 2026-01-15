package me.tomqnto.bedwars.core.game;

import com.sun.istack.internal.Nullable;
import me.tomqnto.bedwars.api.game.IGame;
import me.tomqnto.bedwars.api.game.generator.Generator;
import me.tomqnto.bedwars.api.game.generator.GeneratorType;
import me.tomqnto.bedwars.api.game.team.ITeam;
import me.tomqnto.bedwars.api.region.Cuboid;
import org.bukkit.Location;
import org.bukkit.inventory.ItemStack;

public class ItemGenerator implements Generator {

    private final Location location;
    private final GeneratorType type;
    private final IGame arena;
    private final ITeam team;
    private long interval;
    private ItemStack item;
    private int timer;

    private int tier = 1;
    private int amount = 1;

    public ItemGenerator(Location location, GeneratorType type, IGame arena, @Nullable ITeam team, int radius, ItemStack item) {
        this.location = location;
        this.type = type;
        this.arena = arena;
        this.team = team;
        this.item = item;

        Cuboid c = new Cuboid(location, radius, true);
        c.setMaxY(c.getMaxY() + 5);
        c.setMinY(c.getMaxY() - 2);
        arena.getRegions().add(c);


        tick();
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
    public IGame getArena() {
        return arena;
    }

    @Override
    public void rotate() {

    }

    @Override
    public void setInterval(long intervalTicks) {
        this.interval = intervalTicks;
    }

    @Override
    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public Location getLocation() {
        return location.clone();
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
    @Nullable public ITeam getTeam() {
        return team;
    }

    @Override
    public void spawnHolograms() {

    }

    @Override
    public long getSpawnInterval() {
        return interval;
    }

    @Override
    public int getTier() {
        return tier;
    }

    @Override
    public int getAmount() {
        return amount;
    }

    @Override
    public boolean upgrade() {
        if (tier < 5)
            tier++;
        return tier < 5;
    }

    @Override
    public ItemStack getItem() {
        return item;
    }

    @Override
    public void setItem(ItemStack item) {
        this.item = item;
    }

    @Override
    public void tick() {
        updateHologram();
        if (timer == 0)
            timer = (int) (interval/20);
    }
}
