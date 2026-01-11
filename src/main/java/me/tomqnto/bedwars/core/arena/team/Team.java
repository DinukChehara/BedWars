package me.tomqnto.bedwars.core.arena.team;

import me.tomqnto.bedwars.api.arena.team.Bed;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class Team implements me.tomqnto.bedwars.api.arena.team.Team {

    private final Bed bed;
    private final int maxPlayers;
    private final Set<UUID> players = new HashSet<>();

    public Team(Bed bed, int maxPlayers) {
        this.bed = bed;
        this.maxPlayers = maxPlayers;
    }

    @Override
    public Bed getBed() {
        return bed;
    }

    @Override
    public int getPlayerCount() {
        return players.size();
    }

    @Override
    public int getMaxPlayers() {
        return maxPlayers;
    }

    @Override
    public Set<UUID> getPlayers() {
        return Collections.unmodifiableSet(players);
    }

    @Override
    public boolean addPlayer(UUID player) {
        if (getPlayerCount()<getMaxPlayers()) {
            players.add(player);
            return true;
        }
        return false;
    }

    @Override
    public boolean canJoin() {
        return getPlayerCount() < getMaxPlayers();
    }
}
