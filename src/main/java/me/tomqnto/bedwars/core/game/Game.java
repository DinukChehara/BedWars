package me.tomqnto.bedwars.core.game;

import lombok.Getter;
import me.tomqnto.bedwars.BedWars;
import me.tomqnto.bedwars.api.game.Settings;
import me.tomqnto.bedwars.api.game.IGame;
import me.tomqnto.bedwars.api.game.GameState;
import me.tomqnto.bedwars.api.game.generator.Generator;
import me.tomqnto.bedwars.api.game.team.ITeam;
import me.tomqnto.bedwars.api.game.team.TeamAssigner;
import me.tomqnto.bedwars.api.region.Region;
import me.tomqnto.bedwars.core.game.team.Team;
import me.tomqnto.bedwars.core.game.team.teamAssigners.BalancedTeamAssigner;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Scoreboard;

import java.util.*;

public class Game implements IGame {

    private final Set<UUID> players = new HashSet<>();
    private final Set<UUID> spectators = new HashSet<>();
    private final Set<UUID> respawning = new HashSet<>();
    private final Set<ITeam> teams = new HashSet<>();
    private final Map<UUID, ITeam> playerTeamMap = new HashMap<>();
    private final TeamAssigner assigner = new BalancedTeamAssigner();
    private final List<Region> regions = new ArrayList<>();
    private World world = null;
    private GameState state = GameState.CREATED;
    private final Scoreboard scoreboard = Bukkit.getScoreboardManager().getNewScoreboard();
    @Getter
    private final List<Generator> generators = new ArrayList<>();

    @Getter
    private final BedWars plugin;
    private final String id;
    private final int maxPlayers;
    private final int maxPlayersPerTeam;

    @Getter
    private final GameCycle gameCycle;

    public Game(BedWars plugin, String id, Settings settings) {
        this.plugin = plugin;
        this.id = id;
        this.maxPlayers = settings.getMaxPlayers();
        this.maxPlayersPerTeam = settings.getMaxPlayersPerTeam();

        gameCycle = new GameCycle(this);
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
        Map<String, Character> colors = new HashMap<>();

        colors.put("red", 'c');
        colors.put("blue", '9');
        colors.put("green", 'a');
        colors.put("yellow", 'e');
        colors.put("aqua", 'b');
        colors.put("white", 'f');
        colors.put("pink", 'd');
        colors.put("gray", '8');

        for (String color : colors.keySet()) {
            org.bukkit.scoreboard.Team bukkitTeam = scoreboard.registerNewTeam(color);
            bukkitTeam.setPrefix("§" + colors.get(color));
            teams.add(new Team(color, maxPlayersPerTeam, bukkitTeam));
        }
    }
}
