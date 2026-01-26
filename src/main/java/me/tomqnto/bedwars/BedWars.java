package me.tomqnto.bedwars;

import com.grinderwolf.swm.api.SlimePlugin;
import lombok.Getter;
import me.tomqnto.bedwars.core.managers.GameManager;
import me.tomqnto.bedwars.core.managers.PlayerManager;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

@Getter
public final class BedWars extends JavaPlugin {

    private SlimePlugin slimePlugin;

    private final GameManager gameManager = new GameManager(this);
    private final PlayerManager playerManager = new PlayerManager();

    @Override
    public void onEnable() {

        slimePlugin = (SlimePlugin) Bukkit.getPluginManager().getPlugin("SlimeWorldManager");
    }

    @Override
    public void onDisable() {
    }
}
