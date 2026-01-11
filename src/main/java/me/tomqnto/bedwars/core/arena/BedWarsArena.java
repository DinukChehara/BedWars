package me.tomqnto.bedwars.core.arena;

import me.tomqnto.bedwars.api.arena.GameState;
import me.tomqnto.bedwars.api.arena.team.Team;
import me.tomqnto.bedwars.api.arena.team.TeamAssigner;
import me.tomqnto.bedwars.core.arena.team.teamAssigners.BalancedTeamAssigner;
import org.bukkit.World;
import org.bukkit.entity.Player;

import java.util.*;

public class BedWarsArena implements me.tomqnto.bedwars.api.arena.Arena {

    private final String id;
    private final Set<UUID> players = new HashSet<>();
    private final Set<UUID> spectators = new HashSet<>();
    private final Set<UUID> respawning = new HashSet<>();
    private final Set<Team> teams = new HashSet<>();
    private final Map<UUID, Team> playerTeamMap = new HashMap<>();

    private final TeamAssigner assigner = new BalancedTeamAssigner();

    private final int maxPlayers;
    private final int maxInTeam;

    public BedWarsArena(String id, int maxPlayers, int maxInTeam) {
        this.id = id;
        this.maxPlayers = maxPlayers;
        this.maxInTeam = maxInTeam;
    }

    @Override
    public boolean isSpectator(Player player) {
        return spectators.contains(player.getUniqueId());
    }

    @Override
    public boolean isSpectator(UUID player) {
        return spectators.contains(player);
    }

    @Override
    public boolean isRespawning(UUID player) {
        return respawning.contains(player);
    }

    @Override
    public boolean isGamePlayer(UUID player) {
        return false;
    }

    @Override
    public Set<UUID> getSpectators() {
        return Collections.unmodifiableSet(spectators);
    }

    @Override
    public GameState getState() {
        return null;
    }

    @Override
    public World getWorld() {
        return null;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public Set<UUID> getPlayers() {
        return Collections.unmodifiableSet(players);
    }

    @Override
    public Set<UUID> getRespawning() {
        return Collections.unmodifiableSet(respawning);
    }

    @Override
    public void init(World world) {
        
    }

    @Override
    public void onDeath(UUID player) {
        if (playerTeamMap.get(player).getBed().isAlive())
            respawning.add(player);
        else
            spectators.add(player);
    }

    @Override
    public void join(UUID player) {
        players.add(player);
        assigner.assign(player, teams);
    }

    @Override
    public Set<Team> getTeams() {
        return Collections.unmodifiableSet(teams);
    }

    @Override
    public int getMaxPlayers() {
        return maxPlayers;
    }

    @Override
    public int getMaxInTeam() {
        return maxInTeam;
    }
}
