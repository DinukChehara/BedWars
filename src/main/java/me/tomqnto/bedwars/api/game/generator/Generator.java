package me.tomqnto.bedwars.api.game.generator;

import com.sun.istack.internal.Nullable;
import me.tomqnto.bedwars.api.game.IGame;
import me.tomqnto.bedwars.api.game.team.ITeam;
import org.bukkit.Location;
import org.bukkit.inventory.ItemStack;

public interface Generator {

    /**
     * Create the generator.
     *
     * @param location The location where the generator should be created.
     */
    boolean create(Location location);

    /**
     * @return generator type.
     */
    GeneratorType getType();

    /**
     * Attempt to spawn an item in the generator.
     *
     * @return True if item successfully spawned.
     */
    boolean spawn();

    /**
     * Get the arena assigned to this generator.
     */
    IGame getArena();

    /**
     *  This method is called every tick to rotate the floating block
     */
    void rotate();

    /**
     * Change item spawn interval, in ticks.
     */
    void setInterval(long intervalTicks);

    /**
     * Sets the number of items spawned at once.
     */
    void setAmount(int amount);

    /**
     * Get the location of the generator
     */
    Location getLocation();

    /**
     * Sets the maximum number of items the generator can hold before it stops spawning.
     *
     * @param value the maximum capacity of the generator.
     */
    void setCapacity(int value);

    /**
     * Update the hologram of the generator.
     */
    void updateHologram();

    /**
     * Enables or disables block rotation.
     *
     * @param b true to enable rotation, false to disable it.
     */
    void rotate(boolean b);

    /**
     * Get the team assigned to this generator
     *
     * @return null if this is not a team generator.
     */
    @Nullable
    ITeam getTeam();

    /**
     * Spawns the generator holograms.
     */
    void spawnHolograms();

    /**
     * @return The item spawn interval
     */
    long getSpawnInterval();

    /**
     * @return The tier of the generator
     */
    int getTier();

    /**
     * @return How many items spawn at once
     */
    int getAmount();

    /**
     * Upgrades the generator to the next tier
     *
     * @return false if the generator cannot be upgraded
     */
    boolean upgrade();

    /**
     * Get the spawning item
     */
    ItemStack getItem();

    /**
     * Set the spawning item
     */
    void setItem(ItemStack item);

    /**
     * Updates the generator(the timer, etc) every tick
     */
    void tick();

}
