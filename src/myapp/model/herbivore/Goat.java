package myapp.model.herbivore;

import myapp.config.AppConstants;
import myapp.model.Location;
import myapp.model.abstraction.Animal;
import myapp.model.abstraction.Herbivore;

public class Goat extends Herbivore {

    public Goat(Location location) {
        super(AppConstants.CreatureIcon.GOAT_ICON, AppConstants.CreatureWeight.GOAT, AppConstants.CreatureMaxSize.GOAT, location);
    }

    @Override
    public Animal reproduce() {
        return new Goat(this.location);
    }
}