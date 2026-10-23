package myapp.utility;

import myapp.config.AppConstants.CreatureIcon;
import myapp.model.Island;
import myapp.model.Location;
import myapp.model.abstraction.Animal;
import myapp.model.herbivore.*;
import myapp.model.predator.*;
import java.util.HashMap;
import java.util.Map;

public class PrintUtil {

    public static void printDayResult(Island island) {
        Map<String, Integer> animalCount = new HashMap<>();
        int plantCount = 0;
        String outString;

        for (Location[] row : island.getLocations()) {
            for (Location location : row) {
                plantCount += location.getPlants().size();
                for (Animal animal : location.getAnimals()) {
                    if (!animal.isAlive()) continue;
                    outString = animal.getClass().getSimpleName() + " - " + animal.getIcon();
                    if (animalCount.containsKey(outString)) {
                        animalCount.put(outString, animalCount.get(outString) + 1);
                    } else animalCount.put(outString, 1);
                }
            }
        }

        System.out.println("========================================");
        System.out.println("      СТАТИСТИКА ЖИВЫХ ОРГАНИЗМОВ       ");
        System.out.println("========================================");

        for (Map.Entry<String, Integer> animalsSet : animalCount.entrySet()) {
            System.out.println(animalsSet.getKey() + " - " + animalsSet.getValue());
        }
        System.out.println("Plant " + CreatureIcon.PLANT_ICON + " - " + plantCount);
        System.out.println("========================================");
        System.out.println();
    }

}
