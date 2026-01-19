package me.tomqnto.bedwars.managers;

import me.tomqnto.bedwars.BedWars;
import me.tomqnto.bedwars.api.game.IGame;
import me.tomqnto.bedwars.api.game.Settings;
import me.tomqnto.bedwars.core.game.Game;

import java.util.*;

public class ArenaManager {

    private final BedWars plugin;

    private final Map<String, IGame> games = new HashMap<>();

    public ArenaManager(BedWars plugin) {
        this.plugin = plugin;
    }

    public IGame createGame(String id, Settings settings) {
        if (games.containsKey(id))
            throw new IllegalStateException("Arena already exists: " + id);

        IGame game = new Game(plugin, id, settings);
        games.put(id, game);
        return game;
    }

    public IGame createGame(Settings settings) {
        return createGame(generateGameId(), settings);
    }

    public Optional<IGame> getGame(String id) {
        return Optional.ofNullable(games.get(id));
    }

    public Map<String, IGame> getIdGameMap() {
        return Collections.unmodifiableMap(games);
    }

    public Collection<IGame> getGames() {
        return Collections.unmodifiableCollection(games.values());
    }

    private String generateGameId() {
        return "bw" + UUID.randomUUID().toString().substring(0, 8);
    }

}
