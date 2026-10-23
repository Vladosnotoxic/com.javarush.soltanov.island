package myapp.model.herbivore;

import myapp.config.AppConstants;
import myapp.model.Location;
import myapp.model.abstraction.Animal;
import myapp.model.abstraction.Herbivore;

public class Hog extends Herbivore {

    public Hog(Location location) {
        super(AppConstants.CreatureIcon.HOG_ICON, AppConstants.CreatureWeight.HOG, AppConstants.CreatureMaxSize.HOG, location);
    }

    @Override
    public Animal reproduce() {
        return new Hog(this.location);
    }
}
