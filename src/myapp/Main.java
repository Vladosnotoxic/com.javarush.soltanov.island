package myapp;

public class Main {
    public static void main(String[] args) {
        Island island = Island.getInstance();
        Runner runner = new Runner(island);
        runner.startSimulation();

    }
}