package myapp.utility;

import myapp.config.AppConstants.CreatureIcon;
import myapp.model.Island;
import myapp.model.Location;
import myapp.model.Plant;
import myapp.model.abstraction.Animal;
import myapp.model.herbivore.*;
import myapp.model.predator.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class PrintUtil {
    public static void printResult(ArrayList<Animal> animals, ArrayList<Plant> plants) {

        System.out.println("--------------------------");
        System.out.println("Количество Волков - " + CreatureIcon.WOLF_ICON + " - " + animals.stream().filter(n -> n.getClass() == Wolf.class).count());
        System.out.println("Количество Медведей - " + CreatureIcon.BEAR_ICON + " - " + animals.stream().filter(n -> n.getClass() == Bear.class).count());
        System.out.println("Количество Уток - " + CreatureIcon.DUCK_ICON + " - " + animals.stream().filter(n -> n.getClass() == Duck.class).count());
        System.out.println("Количество Гусениц - " + CreatureIcon.CATERPILLAR_ICON + " - " + animals.stream().filter(n -> n.getClass() == Caterpillar.class).count());
        System.out.println("Количество Лошадей - " + CreatureIcon.HORSE_ICON + " - " + animals.stream().filter(n -> n.getClass() == Horse.class).count());
        System.out.println("Количество Мышей - " + CreatureIcon.MOUSE_ICON + " - " + animals.stream().filter(n -> n.getClass() == Mouse.class).count());
        System.out.println("Количество Растений" + CreatureIcon.PLANT_ICON + " - " + plants.size());
        System.out.println("--------------------------");
    }

    public static void printDayResult(Island island) {
        Map<String, Integer> animalCount = new HashMap<>();
        String outString;

        for (Location[] row : island.getLocations()) {
            for (Location location : row) {
                for (Animal animal : location.getAnimals()) {
                    if (!animal.isAlive()) continue;
                    outString = animal.getClass().getSimpleName() + " - " + animal.getIcon();
                    if (animalCount.containsKey(outString)) {
                        animalCount.put(outString, animalCount.get(outString) + 1);
                    } else animalCount.put(outString, 1);
                }
            }
        }

        System.out.println("--------------------------");
        System.out.println("Количество животных");
        for (Map.Entry<String,Integer> animalsSet : animalCount.entrySet()){
            System.out.println(animalsSet.getKey() + " - " + animalsSet.getValue());
        }
        System.out.println("--------------------------");
    }

}
