package myapp.model.predator;

import myapp.model.Location;
import myapp.model.abstraction.Animal;
import myapp.model.abstraction.Predator;
import myapp.config.AppConstants.*;

public class Wolf extends Predator {
    public static int counter = 0;

    public Wolf(Location location) {
        super(CreatureIcon.WOLF_ICON, CreatureWeight.WOLF, CreatureMaxSize.WOLF, location);
    }

    @Override
    public Animal reproduce() {
        return new Wolf(this.location);
    }
}
