package me.tomqnto.bedwars.core.arena;

import me.tomqnto.bedwars.api.arena.Settings;
import me.tomqnto.bedwars.api.arena.IArena;
import me.tomqnto.bedwars.api.arena.GameState;
import me.tomqnto.bedwars.api.arena.team.ITeam;
import me.tomqnto.bedwars.api.arena.team.TeamAssigner;
import me.tomqnto.bedwars.api.region.Region;
import me.tomqnto.bedwars.core.arena.team.Team;
import me.tomqnto.bedwars.core.arena.team.teamAssigners.BalancedTeamAssigner;
import org.bukkit.World;
import org.bukkit.entity.Player;

import java.util.*;

public class Arena implements IArena {

    private final Set<UUID> players = new HashSet<>();
    private final Set<UUID> spectators = new HashSet<>();
    private final Set<UUID> respawning = new HashSet<>();
    private final Set<ITeam> teams = new HashSet<>();
    private final Map<UUID, ITeam> playerTeamMap = new HashMap<>();
    private final TeamAssigner assigner = new BalancedTeamAssigner();
    private final List<Region> regions = new ArrayList<>();
    private World world = null;
    private GameState state = GameState.PRE_INIT;

    private final String id;
    private final int maxPlayers;
    private final int maxPlayersPerTeam;

    public Arena(String id, Settings settings) {
        this.id = id;
        this.maxPlayers = settings.getMaxPlayers();
        this.maxPlayersPerTeam = settings.getMaxPlayersPerTeam();
    }

    @Override
    public void init(World world) {
        this.world = world;
        world.setAutoSave(false);

        createTeams();
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
        return state;
    }

    @Override
    public void setState(GameState newState) {
        state = newState;
    }

    @Override
    public World getWorld() {
        return world;
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
    public Set<ITeam> getTeams() {
        return Collections.unmodifiableSet(teams);
    }

    @Override
    public int getMaxPlayers() {
        return maxPlayers;
    }

    @Override
    public int getPlayersPerTeam() {
        return maxPlayersPerTeam;
    }

    @Override
    public List<Region> getRegions() {
        return regions;
    }

    @Override
    public void createTeams() {
        List<String> colors = Arrays.asList("red", "blue", "green", "yellow", "aqua", "white", "pink", "gray");

        for (String color : colors)
            teams.add(new Team(color,  maxPlayersPerTeam));

    }
}
