package myapp.model.abstraction;

import myapp.model.Location;

public abstract class Creature {
    protected String name;
    protected String icon;
    protected double weight;
    protected int maxSize;
    protected Location location;
    protected volatile boolean isAlive = true;

    public Creature(String icon, double weight, int maxSize, Location location) {
        this.icon = icon;
        this.weight = weight;
        this.maxSize = maxSize;
        this.location = location;
    }

    public boolean isAlive(){return isAlive;}

    public Location getLocation(){
        return location;
    }

    public int getMaxSize() {
        return maxSize;
    }

    public void die() {
        if (!isAlive) return;
        isAlive = false;
    }

}