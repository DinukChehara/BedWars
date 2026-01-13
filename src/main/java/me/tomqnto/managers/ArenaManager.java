package me.tomqnto.managers;

import me.tomqnto.bedwars.BedWars;
import me.tomqnto.bedwars.api.arena.IArena;

import java.util.HashMap;

public class ArenaManager {

    private final BedWars plugin;

    public final HashMap<String, IArena> arenas = new HashMap<>();

    public ArenaManager(BedWars plugin) {
        this.plugin = plugin;
    }

    public void createArena() {

    }
}
