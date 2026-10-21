package myapp;


import myapp.config.Configuration;
import myapp.model.Island;
import myapp.model.Location;
import myapp.model.abstraction.Animal;
import myapp.utility.PrintUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Runner {
    private final Island island;
    Location[][] locations;

    private int day = 0;
    private final ScheduledExecutorService schedule = Executors.newScheduledThreadPool(1);
    private final ExecutorService executorService = Executors.newFixedThreadPool(8);

    public Runner(Island island) {
        this.island = island;
        locations = island.getLocations();

    }

    public void startSimulation() {

        Location loca = locations[0][0];
        System.out.println("Старт");
        PrintUtil.printResult(loca.getAnimals(), loca.getPlants());

        schedule.scheduleWithFixedDelay(() -> {
                    day++;
                    System.out.println("Итоги дня: " + day);
                    List<Animal> startDayAnimal = new ArrayList<>();

                    for (Location[] row : locations) {
                        for (Location location : row) {
                            startDayAnimal.addAll(location.animalCopy());
                        }
                    }

                    ArrayList<AnimalTask> taskList = new ArrayList<>();
                    for (Animal animal : startDayAnimal)
                        taskList.add(new AnimalTask(island, animal, day));

                    try {
                        executorService.invokeAll(taskList, 2, TimeUnit.SECONDS);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    for (Location[] row : locations) {
                        for (Location loc : row) {
                            loc.getLock().lock();
                            try {
                                loc.removeCreature();
                                loc.growPlants();
                            } finally {
                                loc.getLock().unlock();
                            }
                        }
                    }

                    PrintUtil.printResult(loca.getAnimals(), loca.getPlants());
                    if (day == Configuration.SIMULATION_LAST_DAY) {
                        System.out.println("Симуляция завершена.");
                        schedule.shutdown();
                        executorService.shutdown();
                    }
                },
                0, 2, TimeUnit.SECONDS);

    }


}
