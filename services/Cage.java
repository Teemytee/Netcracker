package services;

import services.Animal;

public interface Cage {
    int getNumber();
    double getArea();
    Condition getCondition();
    boolean isVacantCage(Animal animal);
}
