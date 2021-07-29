import services.Animal;
import services.Cage;
import services.Condition;
import services.Species;

public class CageClass implements Cage {
    private int number;
    private double area;
    private Condition condition;
    private Animal animal;
    private boolean space;

    public CageClass(ConditionClass condition){
        this.condition = condition;
        this.space = true;
    }

    public void putAnimalInCage(Animal animal){
        this.animal = animal;
        this.space = false;
        System.out.println(String.format("Successfully putted %s %s to cage #%s", animal.getName(), animal.getSpecies(),
                this.getNumber()));
    }

    public void removeAnimalFromCage(Animal animal){
        if(animal.getSpecies() == this.animal.getSpecies()){
            this.animal = null;
            this.space = true;
            System.out.println(String.format("Successfully removed %s %s from cage #%s", animal.getName(),
                    animal.getSpecies(), this.getNumber()));
        }
    }

    @Override
    public int getNumber() {
        return this.hashCode();
    }

    @Override
    public double getArea() {
        return this.area;
    }

    @Override
    public Condition getCondition() {
        return this.condition;
    }

    public Animal getAnimal(){
        return this.animal;
    }

    public boolean getSpace(){
        return this.space;
    }

    @Override
    public boolean isVacantCage(Animal animal) {
        for (Species sp: this.condition.isAvailableFor()) {
            if(sp == animal.getSpecies() && this.space){
                return true;
            }
        }
        return false;
    }
}
