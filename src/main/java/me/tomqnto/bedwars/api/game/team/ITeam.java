package me.tomqnto.bedwars.api.game.team;

import me.tomqnto.bedwars.core.game.ItemGenerator;
import org.bukkit.scoreboard.Team;

import java.util.List;
import java.util.Set;
import java.util.UUID;

public interface ITeam {

    /**
     *
     */
    String getName();

    /**
     * Set the bed of the team
     */
    void setBed(Bed bed);

    /**
     * @return The bed of the team
     */
    Bed getBed();

    /**
     * @return The number of players in this team
     */
    int getPlayerCount();

    /**
     * @return The maximum number of players that can be in this team
     */
    int getMaxPlayers();

    /**
     * @return A Set of players in this team
     */
    Set<UUID> getPlayers();

    /**
     * Adds a player to the team
     *
     * @return true if player can be added, else false
     */
    boolean addPlayer(UUID player);

    /**
     * Check if players can join this team
     */
    boolean canJoin();

    Team getBukkitTeam();

    boolean removePlayer(UUID player);

    List<ItemGenerator> getGenerators();
}
