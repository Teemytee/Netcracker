package services.animals;

import services.Animal;
import services.Species;

public class Leon implements Animal {
    private String name;
    private Species species;

    public Leon(String name){
        this.name = name;
        this.species = Species.LEON;
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
