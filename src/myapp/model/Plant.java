package myapp.model;

import myapp.config.AppConstants.*;
import myapp.model.abstraction.Creature;

public class Plant extends Creature {

    public Plant(Location location) {
        super(CreatureIcon.PLANT_ICON, CreatureMaxWeight.PLANTS, CreatureMaxSize.PLANTS, location);
    }

}