import services.Animal;
import services.Species;
import services.Zoo;
import services.animals.Giraffe;
import services.animals.Leon;
import services.animals.Penguin;
import services.animals.Squirrel;

import java.sql.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class ZooClass implements Zoo {
    private List<CageClass> cages = new ArrayList<>();
    private List<InhibitionLog> log;
    private static Connection connection;
    private static final String DB_URL = "jdbc:postgresql://127.0.0.1:5432/testhw";
    private static final String USER = "postgres";
    private static final String PASS = "root";

    @Override
    public void checkInAnimal(Animal animal) {
        boolean haveVacantCage = false;
        for (CageClass cage : this.cages) {
            if(cage.isVacantCage(animal)){
                haveVacantCage = true;
                cage.putAnimalInCage(animal);
                this.commitCheckIn(animal, cage);
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
            if(!cage.getSpace() && cage.getAnimal().getSpecies() == animal.getSpecies()
                    && cage.getAnimal().getName().equals(animal.getName())){
                cage.removeAnimalFromCage(animal);
                this.commitCheckOut(cage);
                this.makeCheckOutRecord(animal);
                return;
            } else{
                System.out.println("Found no animals with this name in cage #" + cage.getNumber());
            }
        }
    }

    @Override
    public void getHistory() {
        for (InhibitionLog log:log) {
            if(log.getCheckInDate() == null){
                System.out.println("Check out date: " + log.getCheckOutDate() + ". Species: " + log.getAnimalSpecies()
                + ". Name: " + log.getAnimalName());
            } else{
                System.out.println("Check in date: " + log.getCheckInDate() + ". Species: " + log.getAnimalSpecies()
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
        try {
            connection = DriverManager
                    .getConnection(DB_URL, USER, PASS);

        } catch (SQLException e) {
            e.printStackTrace();
            return;
        }
        String pattern = "MM/dd/yyyy HH:mm:ss";
        DateFormat df = new SimpleDateFormat(pattern);
        String query = "INSERT INTO animal_records (check_in, spec, name) VALUES ('" + df.format(Calendar.getInstance().getTime()) +
                "', '" + animal.getSpecies() + "', '" + animal.getName() +"');";
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(query);
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void makeCheckOutRecord(Animal animal){
        try {
            connection = DriverManager
                    .getConnection(DB_URL, USER, PASS);

        } catch (SQLException e) {
            e.printStackTrace();
            return;
        }
        String pattern = "MM/dd/yyyy HH:mm:ss";
        DateFormat df = new SimpleDateFormat(pattern);

        String query = "INSERT INTO animal_records (check_out, spec, name) VALUES ('" + df.format(Calendar.getInstance().getTime()) +
                "', '" + animal.getSpecies() + "', '" + animal.getName() +"');";
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(query);
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void loadCages(){
        try {
            connection = DriverManager
                    .getConnection(DB_URL, USER, PASS);

        } catch (SQLException e) {
            e.printStackTrace();
            return;
        }
        String query = "SELECT * FROM cages;";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                CageClass cage = new CageClass();
                cage.setNumber(resultSet.getInt(1));
                cage.setSpace(Boolean.parseBoolean(resultSet.getString(3)));
                List<Species> availableFor = new ArrayList<>();
                availableFor.add(Species.valueOf(resultSet.getString(4)));
                cage.setCondition(new ConditionClass(availableFor));
                if(resultSet.getString(2) != null){
                    if(resultSet.getString(4).equals("LEON")){
                        Animal leon = new Leon(resultSet.getString(2));
                        cage.setAnimal(leon);
                    }
                    if(resultSet.getString(4).equals("GIRAFFE")){
                        Animal giraffe = new Giraffe(resultSet.getString(2));
                        cage.setAnimal(giraffe);
                    }
                    if(resultSet.getString(4).equals("SQUIRREL")){
                        Animal squirrel = new Squirrel(resultSet.getString(2));
                        cage.setAnimal(squirrel);
                    }
                    if(resultSet.getString(4).equals("PENGUIN")){
                        Animal penguin = new Penguin(resultSet.getString(2));
                        cage.setAnimal(penguin);
                    }

                }
                cages.add(cage);
            }
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void showCages(){
        for (CageClass cage : cages) {
            System.out.println("Cage id: " + cage.getNumber());
            System.out.println("Cage space: " + cage.getSpace());
            System.out.println("For what type of animal this cage have been made: " +
                    cage.getCondition().isAvailableFor().get(0));
            if(cage.getAnimal() != null && !cage.getAnimal().getName().equals("null")){
                System.out.println("Name of animal in this cage: " + cage.getAnimal().getName());
            } else{
                System.out.println("No animal in this cage");
            }
            System.out.println("==============");
        }
    }

    public void commitCheckIn(Animal animal, CageClass cage){
        try {
            connection = DriverManager
                    .getConnection(DB_URL, USER, PASS);

        } catch (SQLException e) {
            e.printStackTrace();
            return;
        }
        String query = "UPDATE cages SET animal_name = '" + animal.getName() + "', spac = 'false' where id = "
                + cage.getNumber() + ";";

        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(query);
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void commitCheckOut(CageClass cage){
        try {
            connection = DriverManager
                    .getConnection(DB_URL, USER, PASS);

        } catch (SQLException e) {
            e.printStackTrace();
            return;
        }
        String query = "UPDATE cages SET animal_name = '" + null + "', spac = 'true' where id = "
                + cage.getNumber() + ";";
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(query);
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void loadLog(){
        try {
            connection = DriverManager
                    .getConnection(DB_URL, USER, PASS);

        } catch (SQLException e) {
            e.printStackTrace();
            return;
        }
        String query = "SELECT * FROM animal_records";
        String pattern = "MM/dd/yyyy HH:mm:ss";
        DateFormat df = new SimpleDateFormat(pattern);
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            List<InhibitionLog> log = new ArrayList<>();
            while (resultSet.next()){
                if(resultSet.getString(2) != null){
                    log.add(new InhibitionLog(df.parse(resultSet.getString(2)), null,
                            Species.valueOf(resultSet.getString(4)), resultSet.getString(5)));
                } else{
                    log.add(new InhibitionLog(null, df.parse(resultSet.getString(3)),
                            Species.valueOf(resultSet.getString(4)), resultSet.getString(5)));
                }
            }
            this.log = log;
            connection.close();
        } catch (SQLException | ParseException throwables) {
            throwables.printStackTrace();
        }
    }
}
