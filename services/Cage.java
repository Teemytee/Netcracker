package services;

public interface Cage {
    int getNumber();
    double getArea();
    Condition getCondition();
    boolean isVacantCage(Animal animal);
}
