package me.tomqnto.bedwars.api.arena.generator;

import com.sun.istack.internal.Nullable;
import me.tomqnto.bedwars.api.arena.IArena;
import me.tomqnto.bedwars.api.arena.team.ITeam;
import org.bukkit.Location;
import org.bukkit.inventory.ItemStack;

public interface IGenerator {

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
     * Sets the item that this generator will spawn.
     *
     * @param item the item to be generated.
     */
    void setItem(ItemStack item);

    /**
     * Get the arena assigned to this generator.
     */
    IArena getArena();

    /**
     *  This method is called every tick to rotate the floating block
     */
    void rotate();

    /**
     * Change item spawn delay, in seconds.
     */
    void setDelay(int delaySeconds);

    /**
     * Sets the number of items spawned at once.
     */
    void setAmount(int amount);

    /**
     * Get the location of the generator
     */
    Location getLocation();

    /**
     * Get the item of the generator
     */
    ItemStack getItem();

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

}
