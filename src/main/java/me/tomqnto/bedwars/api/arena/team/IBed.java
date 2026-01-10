package me.tomqnto.bedwars.api.arena.team;

import org.bukkit.Location;

import java.util.List;

public interface IBed {

    /**
     * @return true if the bed is not broken
     */
    boolean isAlive();

    /**
     * Ran when the bed is broken
     */
    void breakBed();

    /**
     * @return The location of the bed head block
     */
    Location getHead();

    /**
     * @return The location of the bed foot block
     */
    Location getFoot();

    /**
     * @return Both bed head and bed foot locations
     */
    List<Location> getAllBlocks();
}
