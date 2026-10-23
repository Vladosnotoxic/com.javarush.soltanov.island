package myapp.model.herbivore;

import myapp.config.AppConstants;
import myapp.model.Location;
import myapp.model.abstraction.Animal;
import myapp.model.abstraction.Herbivore;

public class Sheep extends Herbivore {

    public Sheep(Location location) {
        super(AppConstants.CreatureIcon.SHEEP_ICON, AppConstants.CreatureWeight.SHEEP, AppConstants.CreatureMaxSize.SHEEP, location);
    }

    @Override
    public Animal reproduce() {
        return new Sheep(this.location);
    }
}
