package services.animals;

import services.Animal;
import services.Species;

public class Giraffe implements Animal {
    private String name;
    private Species species;

    public Giraffe(String name){
        this.name = name;
        this.species = Species.GIRAFFE;
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
