package me.tomqnto.bedwars.core.game.team;

import me.tomqnto.bedwars.api.game.team.Bed;
import me.tomqnto.bedwars.api.game.team.ITeam;
import org.bukkit.Bukkit;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class Team implements ITeam {

    private final String name;
    private Bed bed;
    private final int maxPlayers;
    private final Set<UUID> players = new HashSet<>();
    private final org.bukkit.scoreboard.Team bukkitTeam;

    public Team(String name, int maxPlayers, org.bukkit.scoreboard.Team team) {
        this.name = name;
        this.maxPlayers = maxPlayers;
        bukkitTeam = team;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setBed(Bed bed) {
        this.bed = bed;
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
            bukkitTeam.addEntry(Bukkit.getPlayer(player).getName());
            return true;
        }
        return false;
    }

    @Override
    public boolean canJoin() {
        return getPlayerCount() < getMaxPlayers();
    }

    @Override
    public org.bukkit.scoreboard.Team getBukkitTeam() {
        return bukkitTeam;
    }

    @Override
    public boolean removePlayer(UUID player) {
        if (players.contains(player)) {
            players.remove(player);
            bukkitTeam.removeEntry(Bukkit.getPlayer(player).getName());

            return true;
        }
        return false;
    }

}
