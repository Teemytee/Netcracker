import services.Animal;
import services.Species;
import services.Zoo;

import java.util.Date;
import java.util.List;

public class ZooClass implements Zoo {
    private List<CageClass> cages;
    private List<InhibitionLog> log;

    @Override
    public void checkInAnimal(Animal animal) {
        boolean haveVacantCage = false;
        for (CageClass cage : this.cages) {
            if(cage.isVacantCage(animal)){
                haveVacantCage = true;
                cage.putAnimalInCage(animal);
                this.makeCheckInRecord(animal);
                return;
            } else{
                System.out.println(String.format("Cannot put %s %s into cage #%s", animal.getName(), animal.getSpecies(),cage.getNumber()));
            }
        }
        if(!haveVacantCage){
            throw new IllegalArgumentException("There's no place in zoo for this animal");
        }
    }

    @Override
    public void checkOutAnimal(Animal animal) {
        for (CageClass cage : this.cages) {
            if(!cage.getSpace() && cage.getAnimal().getSpecies() == animal.getSpecies()){
                cage.removeAnimalFromCage(animal);
                this.makeCheckOutRecord(animal);
                return;
            }
        }
    }

    @Override
    public void getHistory() {
        for (InhibitionLog log:log) {
            if(log.getCheckInDate() == null){
                System.out.println("Check out date: " + log.getCheckOutDate() + ". services.Species: " + log.getAnimalSpecies()
                + ". Name: " + log.getAnimalName());
            } else{
                System.out.println("Check in date: " + log.getCheckInDate() + ". services.Species: " + log.getAnimalSpecies()
                        + ". Name: " + log.getAnimalName());
            }
        }
    }

    public Animal getAnimalFromZoo(String name, Species species){
        for (CageClass cage : this.cages){
            if(cage.getAnimal() != null){
                if (cage.getAnimal().getName().equals(name) && cage.getAnimal().getSpecies() == species){
                    return cage.getAnimal();
                }
            }
        }
        return null;
    }

    public void makeCheckInRecord(Animal animal){
        this.log.add(new InhibitionLog(new Date(), null, animal.getSpecies(), animal.getName()));
    }

    public void makeCheckOutRecord(Animal animal){
        this.log.add(new InhibitionLog(null, new Date(), animal.getSpecies(), animal.getName()));
    }

    public static class ZooBuilder {
        private ZooClass zoo;

        public ZooBuilder(){
            zoo = new ZooClass();
        }

        public ZooBuilder withCages(List<CageClass> cages){
            zoo.cages = cages;
            return this;
        }

        public ZooBuilder withLog(List<InhibitionLog> log){
            zoo.log = log;
            return this;
        }

        public ZooClass build(){
            return zoo;
        }
    }
}
