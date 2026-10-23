package myapp.model.herbivore;

import myapp.model.Location;
import myapp.config.AppConstants;
import myapp.model.abstraction.Animal;
import myapp.model.abstraction.Herbivore;

public class Caterpillar extends Herbivore {


    public Caterpillar(Location location) {
        super(AppConstants.CreatureIcon.CATERPILLAR_ICON, AppConstants.CreatureWeight.CATERPILLAR, AppConstants.CreatureMaxSize.CATERPILLAR, location);
    }

    @Override
    public Animal reproduce() {
        return new Caterpillar(this.location);
    }

}
