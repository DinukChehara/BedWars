package me.tomqnto.bedwars.core.arena;

import com.google.common.collect.ImmutableList;
import me.tomqnto.bedwars.api.arena.GameState;
import me.tomqnto.bedwars.api.arena.IArena;
import me.tomqnto.bedwars.api.arena.team.ITeam;
import org.bukkit.World;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;

import java.util.*;

public class Arena implements IArena {

    private final String id;
    private final Set<UUID> players = new HashSet<>();
    private final Set<UUID> spectators = new HashSet<>();
    private final Set<UUID> respawning = new HashSet<>();
    private final Set<ITeam> teams = new HashSet<>();
    private final Map<UUID, ITeam> playerTeamMap = new HashMap<>();

    public Arena(String id) {
        this.id = id;
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
        for (ITeam team : teams) {
            if (team.getPlayerCount()<team.getMaxPlayers())
                team.addPlayer(player);
            return;
        }
    }
}
