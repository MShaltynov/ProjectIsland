package engine;

import animals.Animal;
import field.InitialField;
import field.Island;
import render.GameRender;

public class GameEngine {
    private int delay;
    private GameRender gameRender;
    Island island;
    int dayNumber = 1;
    InitialField initialField;

    public GameEngine(int delay, Island island, GameRender gameRender) {
        this.delay = delay;
        this.island = island;
        this.gameRender = gameRender;
        initialField = new InitialField(island);
    }

    public void start() {
        initialField.populateIsland(island);
        while (island.getAllAnimals().stream().count() > 0) {
            try {
                long startTime = System.currentTimeMillis();
                System.out.println("===============================================================================");
                System.out.println("Day: " + dayNumber + ", Animal amount= " + gameRender.getTotalAmount(island));
                nextDay();
                gameRender.printMap(island);
                Thread.sleep(delay);
                dayNumber++;
                System.out.println("Cycle duration: " + (System.currentTimeMillis() - startTime) + "ms");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("\uD83C\uDFC1 Game is finished!");
    }

    private void nextDay() {
        long startTime = System.currentTimeMillis();
        for (Animal currentAnimal : island.getAllAnimals()
        ) {
            currentAnimal.move(initialField.getSpeedFromString(currentAnimal));
            currentAnimal.eat();
            currentAnimal.checkEnergy();
        }
        System.out.println("Moving and eating time: "+(System.currentTimeMillis()-startTime) +"ms");

        initialField.printEatenAnimals();
        startTime = System.currentTimeMillis();
        initialField.breed();
        System.out.println("Breed time: "+(System.currentTimeMillis()-startTime) +"ms");
        startTime = System.currentTimeMillis();
        initialField.consumeEnergy();
        System.out.println("Set energy after day time: "+(System.currentTimeMillis()-startTime) +"ms");
    }


}
