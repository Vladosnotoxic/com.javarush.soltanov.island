package myapp.model.predator;

import myapp.Location;
import myapp.config.AppConstants;
import myapp.model.abstraction.Animal;
import myapp.model.abstraction.Predator;

public class Bear extends Predator {

    public Bear(Location location) {
        super(AppConstants.CreatureIcon.BEAR_ICON, AppConstants.CreatureMaxWeight.BEAR, AppConstants.CreatureMaxSize.BEAR, location);
    }

@Override
    public Animal reproduce() {
        return new Bear(this.location);
    }
}