package myapp.model.predator;

import myapp.model.Location;
import myapp.config.AppConstants;
import myapp.model.abstraction.Animal;
import myapp.model.abstraction.Predator;

public class Bear extends Predator {
    public static int counter = 0;

    public Bear(Location location) {
        super(AppConstants.CreatureIcon.BEAR_ICON, AppConstants.CreatureWeight.BEAR, AppConstants.CreatureMaxSize.BEAR, location);
    }

@Override
    public Animal reproduce() {
        return new Bear(this.location);
    }
}