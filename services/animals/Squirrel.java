package services.animals;

import services.Animal;
import services.Species;

public class Squirrel implements Animal {
    private String name;
    private Species species;

    public Squirrel(String name){
        this.name = name;
        this.species = Species.SQUIRREL;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Species getSpecies() {
        return this.species;
    }

    @Override
    public String toString() {
        return "AnimalRealization{" +
                "name='" + name + '\'' +
                ", species=" + species +
                '}';
    }
}
