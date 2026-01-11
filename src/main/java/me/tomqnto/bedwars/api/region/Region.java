package me.tomqnto.bedwars.api.region;

import org.bukkit.Location;

public interface Region {

    boolean isInRegion(Location location);

    boolean isProtected();

}
