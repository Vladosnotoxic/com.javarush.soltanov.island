package myapp.utility;

import myapp.config.AppConstants;
import myapp.Location;
import myapp.model.Plant;
import myapp.model.abstraction.Animal;

public class LocationUtil {

    public static boolean isPlantsNonMax(Location location, Plant plant){
        return location.getPlants().size() < AppConstants.CreatureMaxSize.PLANTS;
    }

    public static boolean isAnimalNonMax(Location location, Animal animal){
        return location.getAnimals().stream().filter(n -> n.isAlive() && n.getClass() == animal.getClass()).count() < animal.getMaxSize();
    }

    public static boolean isAnimalMin(Location location, Animal animal){
        return location.getAnimals().stream().filter(n -> n.isAlive() && n.getClass() == animal.getClass()).count() >= 2;
    }

}

