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
import net.md_5.bungee.api.chat.BaseComponent;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Scoreboard;

import java.util.*;

public class Game implements IGame {

    private final Set<UUID> players = new HashSet<>();
    private final Set<UUID> spectators = new HashSet<>();
    private final Set<UUID> respawning = new HashSet<>();
    private final Set<ITeam> teams = new HashSet<>();
    private final Set<UUID> leftPlayers = new HashSet<>();
    private final Map<UUID, ITeam> playerTeamMap = new HashMap<>();
    private final TeamAssigner assigner = new BalancedTeamAssigner();
    private final List<Region> regions = new ArrayList<>();
    private World world = null;
    private GameState state = GameState.CREATED;
    private final Scoreboard scoreboard = Bukkit.getScoreboardManager().getNewScoreboard();
    @Getter
    private final List<Generator> generators = new ArrayList<>();

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
        if (state == GameState.ACTIVE) {
            if (isFinal(player)) {
                Bukkit.getPlayer(player).sendMessage(ChatColor.RED + "Your bed was destroyed, you are now spectating the match");
                // TO DO: MAKE A SPECTATOR
            } else {
                // TO DO: RESPAWN
            }
        } else if (state == GameState.ENDED) {
            Bukkit.getPlayer(player).sendMessage(ChatColor.RED + "That game has ended");

        } else if (state == GameState.WAITING) {
            players.add(player);
            assigner.assign(player, teams);
        }
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
        List<String> colors = Arrays.asList("RED", "BLUE", "GREEN", "YELLOW", "AQUA", "WHITE", "PINK", "GRAY");

        for (String color : colors) {
            org.bukkit.scoreboard.Team bukkitTeam = scoreboard.registerNewTeam(color);
            bukkitTeam.setPrefix(String.valueOf(ChatColor.valueOf(color)));
            teams.add(new Team(color, maxPlayersPerTeam, bukkitTeam));
        }
    }

    public boolean isFinal(UUID player) {
        if (state == GameState.ACTIVE)
            return playerTeamMap.get(player).getBed().isAlive();
        return false;
    }

    @Override
    public void leave(UUID player) {
        if (state == GameState.ACTIVE) {
            onDeath(player);
            if (!isFinal(player))
                leftPlayers.add(player);
        } else {
            if (playerTeamMap.containsKey(player))
                playerTeamMap.get(player).removePlayer(player);
        }

        // send to lobby
    }
}
