package animals.predators;

import animals.Animal;
import animals.Predators;
import field.Cell;
import field.InitialField;

import java.util.HashMap;
import java.util.Map;

public class Fox extends Predators {
    public Fox(InitialField initialField, int energyCapacity,int givenEnergyIfEaten) {
        super(initialField);
        this.energyCapacity = energyCapacity;
        this.givenEnergyIfEaten = givenEnergyIfEaten;
    }
    private boolean breedableStatus = true;

    @Override
    public boolean getBreedableStatus() {
        return breedableStatus;
    }

    @Override
    public void setBreedableStatus(boolean breedableStatus) {
        this.breedableStatus = breedableStatus;
    }
    @Override
    public Animal getNewAnimal(InitialField initialField) {
        return new Fox(initialField,5,5);
    }
    private int givenEnergyIfEaten;

    public int getGivenEnergyIfEaten() {
        return givenEnergyIfEaten;
    }
    private int energyCapacity;

    public void setEnergyCapacity(int energyCapacity) {
        this.energyCapacity = energyCapacity;
    }

    public int getEnergyCapacity() {
        return energyCapacity;
    }


    private Cell position;
    private Map<String,Integer> chanceToEat=new HashMap<>(){{
        put("rabbit",70);
        put("mouse",90);
        put("duck",60);
        put("caterpillar",40);
    }};
    @Override
    public Map<String, Integer> getChanceToEatList() {
        return chanceToEat;
    }
    @Override
    public Cell getPosition() {
        return position;
    }

    @Override
    public void setPosition(Cell positionCell) {
        this.position = positionCell;
    }
    @Override
    public String toString() {
        return "fox";
    }

    @Override
    public String getIcon() {
        return  "🦊";
    }
}
