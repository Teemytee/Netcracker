package services;

import services.Animal;

public interface Zoo {
    void checkInAnimal(Animal animal);
    void checkOutAnimal(Animal animal);
    void getHistory();
}
