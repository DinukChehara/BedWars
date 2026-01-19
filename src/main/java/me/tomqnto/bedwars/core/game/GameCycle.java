package me.tomqnto.bedwars.core.game;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import me.tomqnto.bedwars.api.game.Cycle;
import me.tomqnto.bedwars.api.game.GameState;
import me.tomqnto.bedwars.api.game.generator.Generator;
import org.bukkit.scheduler.BukkitRunnable;

@RequiredArgsConstructor
@Getter
public class GameCycle implements Cycle {

    private final Game game;
    private final BukkitRunnable task = new BukkitRunnable() {
        @Override
        public void run() {
            runCycle();
        }
    };
    private int ticks = 0;

    private void runCycle() {
        if (game.getState().equals(GameState.ENDED)) {
            endCycle();
            return;
        }

        if (game.getState() == GameState.CREATED) {
            game.setState(GameState.WAITING);
        }

        for (Generator gen : game.getGenerators())
            gen.tick();

        ticks++;
    }

    @Override
    public void startCycle() {
        task.runTaskTimer(game.getPlugin(), 0L, 0L);
    }

    @Override
    public void endCycle() {
        task.cancel();
    }
}
