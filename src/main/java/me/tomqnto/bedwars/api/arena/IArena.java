package me.tomqnto.bedwars.api.arena;

import org.bukkit.World;
import org.bukkit.entity.Player;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

public interface IArena {

    /**
     * Check if the given player is spectating on this arena
     */
    boolean isSpectator(Player player);

    /**
     * Check if the given player is spectating on this arena
     */
    boolean isSpectator(UUID player);

    /**
     * Check if the given player is respawning on this arena
     */
    boolean isRespawning(UUID player);

    /**
     * Check if the given player is a member of this match
     */
    boolean isGamePlayer(UUID player);

    /**
     *@return A list of all players currently spectating this arena
     */
    Set<UUID> getSpectators();

    /**
     * Get arena state
     */
    GameState getState();

    /**
     * Get the arena world
     */
    World getWorld();

    /**
     * Get arena id
     */
    String getId();

    /**
     *@return A set of all players that are members of this match
     */
    Set<UUID> getPlayers();

    /**
     * Get a set of all the respawning players
     */
    Set<UUID> getRespawning();

    /**
     * Initialize the arena after loading the world
     */
    void init(World world);

    /**
     * Ran when a player dies in this arena
     */
    void onDeath(UUID player);

    /**
     * Joins the specified player to the game
     */
    void join(UUID player);
}
