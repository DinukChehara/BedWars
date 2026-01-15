package me.tomqnto.managers;

import lombok.Getter;
import me.tomqnto.bedwars.BedWars;
import me.tomqnto.bedwars.api.arena.IArena;
import me.tomqnto.bedwars.api.arena.Settings;
import me.tomqnto.bedwars.core.arena.Arena;
import me.tomqnto.bedwars.core.arena.ArenaSettings;
import org.yaml.snakeyaml.nodes.CollectionNode;

import java.util.*;

public class ArenaManager {

    private final Map<String, IArena> arenas = new HashMap<>();

    public IArena createArena(String id, Settings settings) {
        if (arenas.containsKey(id))
            throw new IllegalStateException("Arena already exists: " + id);

        IArena arena = new Arena(id, settings);
        arenas.put(id, arena);
        return arena;
    }

    public IArena createArena(Settings settings) {
        return createArena(generateArenaId(), settings);
    }

    public Optional<IArena> getArena(String id) {
        return Optional.ofNullable(arenas.get(id));
    }

    public Map<String, IArena> getArenasMap() {
        return Collections.unmodifiableMap(arenas);
    }

    public Collection<IArena> getArenas() {
        return Collections.unmodifiableCollection(arenas.values());
    }

    private String generateArenaId() {
        return "bw" + UUID.randomUUID().toString().substring(0, 8);
    }

}
