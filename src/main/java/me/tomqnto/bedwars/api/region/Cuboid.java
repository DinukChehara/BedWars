package me.tomqnto.bedwars.api.region;

import lombok.Getter;
import lombok.Setter;
import org.bukkit.Location;

@Getter
public class Cuboid implements Region{

    private final int minX, maxX;
    @Setter
    private int minY, maxY;
    private final int minZ, maxZ;

    private final boolean protect;

    public Cuboid(Location loc, int radius, boolean protect) {

        Location l1 = loc.clone().subtract(radius, radius, radius);
        Location l2 = loc.clone().add(radius, radius, radius);

        minX = Math.min(l1.getBlockX(), l2.getBlockX());
        maxX = Math.max(l1.getBlockX(), l2.getBlockX());

        minY = Math.min(l1.getBlockY(), l2.getBlockY());
        maxY = Math.max(l1.getBlockY(), l2.getBlockY());

        minZ = Math.min(l1.getBlockZ(), l2.getBlockZ());
        maxZ = Math.max(l1.getBlockZ(), l2.getBlockZ());

        this.protect = protect;
    }

    @Override
    public boolean isInRegion(Location l) {
        return (l.getBlockX() <= maxX && l.getBlockX() >= minX) && (l.getBlockY() <= maxY && l.getBlockY() >= minY)
                && (l.getBlockZ() <= maxZ && l.getBlockZ() >= minZ);
    }

    @Override
    public boolean isProtected() {
        return protect;
    }

}
