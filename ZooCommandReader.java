import services.Animal;
import services.Species;
import services.animals.Giraffe;
import services.animals.Leon;
import services.animals.Penguin;
import services.animals.Squirrel;

import java.util.Scanner;

public class ZooCommandReader {
    ZooClass zoo;

    public ZooCommandReader(ZooClass zoo){
        this.zoo = zoo;
    }

    public void start(){
        this.showTutorial();
        while (true){
            this.readCommand();
        }
    }

    public void readCommand(){
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String[] command = str.split("\\s");

        if(command[0].equals("check-in")){
            if(command[1].equals("LEON")){
                Animal leon = new Leon(command[2]);
                this.zoo.checkInAnimal(leon);
            }
            if(command[1].equals("GIRAFFE")){
                Animal giraffe = new Giraffe(command[2]);
                this.zoo.checkInAnimal(giraffe);
            }
            if(command[1].equals("SQUIRREL")){
                Animal squirrel = new Squirrel(command[2]);
                this.zoo.checkInAnimal(squirrel);
            }
            if(command[1].equals("PENGUIN")){
                Animal penguin = new Penguin(command[2]);
                this.zoo.checkInAnimal(penguin);
            }
        } else if(command[0].equals("check-out")){
            if(this.zoo.getAnimalFromZoo(command[2], Species.valueOf(command[1])) != null){
                this.zoo.checkOutAnimal(this.zoo.getAnimalFromZoo(command[2], Species.valueOf(command[1])));
            } else{
                System.out.println("There's no such animal in this zoo");
            }
        } else if(command[0].equals("exit")){
            System.exit(0);
        } else if(command[0].equals("log")){
            this.zoo.getHistory();
        } else{
            System.out.println("Wrong command. Try again");
        }
    }

    public void showTutorial(){
        System.out.println("Tutorial");
        System.out.println("1. check-in [ANIMAL_SPECIES] [ANIMAl_NAME] - this command puts an animal to cage. Only if" +
                "there's available cage for this one");
        System.out.println("2. check-out [ANIMAL_SPECIES] [ANIMAL_NAME] - this command removes an animal from cage and" +
                "zoo. Only if there this animal already lives in zoo");
        System.out.println("3. exit - shutdown program");
        System.out.println("4. log - prints all records that have been done at moment");
    }
}
