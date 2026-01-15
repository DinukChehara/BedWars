package me.tomqnto.bedwars.api.game;

import me.tomqnto.bedwars.api.game.team.ITeam;
import me.tomqnto.bedwars.api.region.Region;
import org.bukkit.World;
import org.bukkit.entity.Player;

import java.util.List;
import java.util.Set;
import java.util.UUID;

public interface IGame {

    /**
     * Check if the given player is spectating on this game
     */
    boolean isSpectator(Player player);

    /**
     * Check if the given player is spectating on this game
     */
    boolean isSpectator(UUID player);

    /**
     * Check if the given player is respawning on this game
     */
    boolean isRespawning(UUID player);

    /**
     * Check if the given player is a member of this match
     */
    boolean isGamePlayer(UUID player);

    /**
     *@return A list of all players currently spectating this game
     */
    Set<UUID> getSpectators();

    /**
     * Get game state
     */
    GameState getState();

    /**
     * Change the game state
     */
    void setState(GameState newState);

    /**
     * Get the game world
     */
    World getWorld();

    /**
     * Get game id
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
     * Initialize the game after loading the world
     */
    void init(World world);

    /**
     * Ran when a player dies in this game
     */
    void onDeath(UUID player);

    /**
     * Joins the specified player to the game
     */
    void join(UUID player);

    /**
     * @return The set of teams in this game
     */
    Set<ITeam> getTeams();

    /**
     * Get maximum allowed players amount
     */
    int getMaxPlayers();

    /**
     * Get maximum players allowed in a team
     */
    int getPlayersPerTeam();

    /**
     * @return The list of regions in this game
     */
    List<Region> getRegions();

    /**
     * Create teams for the game
     */
    void createTeams();
}
