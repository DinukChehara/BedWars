package me.tomqnto.bedwars.core.game;

import com.sun.istack.internal.Nullable;
import me.tomqnto.bedwars.api.game.IGame;
import me.tomqnto.bedwars.api.game.generator.Generator;
import me.tomqnto.bedwars.api.game.generator.GeneratorTier;
import me.tomqnto.bedwars.api.game.generator.GeneratorType;
import me.tomqnto.bedwars.api.game.team.ITeam;
import me.tomqnto.bedwars.api.region.Cuboid;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Item;
import org.bukkit.inventory.ItemStack;

public class ItemGenerator implements Generator {

    private final Location location;
    private final GeneratorType type;
    private final IGame arena;
    private final ITeam team;
    private long interval;
    private ItemStack item;
    private int timer;
    private int capacity;

    private GeneratorTier tier;
    private int amount = 1;

    public ItemGenerator(Location location, GeneratorType type, IGame game, @Nullable ITeam team, int radius, ItemStack item, int capacity) {
        this.location = location;
        this.type = type;
        this.arena = game;
        this.team = team;
        this.item = item;
        this.capacity = capacity;

        Cuboid c = new Cuboid(location, radius, true);
        c.setMaxY(location.getBlockY() + 5);
        c.setMinY(location.getBlockY() - 2);
        game.getRegions().add(c);

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
        capacity = value;
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
    public GeneratorTier getTier() {
        return tier;
    }

    @Override
    public int getAmount() {
        return amount;
    }

    @Override
    public boolean upgrade() {
        GeneratorTier nextTier = getNextTier();
        if (nextTier==null) return false;

        this.tier = nextTier;
        applyTier();
        return true;
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
        if (--timer > 0) {
            return;
        }

        timer = (int) interval;

        if (!canSpawn()) return;

        updateHologram();
    }

    private boolean canSpawn() {
        int nearby = countNearbyItems();
        return nearby < capacity;
    }

    private int countNearbyItems() {
        int count = 0;
        for (Entity e : location.getWorld().getNearbyEntities(location, 1.5, 1.5, 1.5)) {
            if (e instanceof Item) {
                Item itemEntity = (Item) e;
                if (itemEntity.getItemStack().isSimilar(item)) {
                    count += itemEntity.getItemStack().getAmount();
                }
            }
        }
        return count;
    }


    private void start() {
        timer = (int) interval;
    }

    private GeneratorTier getNextTier() {
        if (tier == GeneratorTier.DIAMOND_I) return GeneratorTier.DIAMOND_II;
        if (tier == GeneratorTier.DIAMOND_II) return GeneratorTier.DIAMOND_III;
        if (tier == GeneratorTier.EMERALD_I) return GeneratorTier.EMERALD_II;
        if (tier == GeneratorTier.EMERALD_II) return GeneratorTier.EMERALD_III;
        return null;
    }

    private void applyTier() {
        setInterval(tier.getInterval());
        setCapacity(tier.getCapacity());
    }

}
