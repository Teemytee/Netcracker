import services.Species;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        doDemo();
    }

    public static void doDemo(){
        // This code is needed to make cages
        List<Species> availableForLeons = new ArrayList<>();
        availableForLeons.add(Species.LEON);

        List<Species> availableForGiraffes = new ArrayList<>();
        availableForGiraffes.add(Species.GIRAFFE);

        // Here are Lists of available species move into ConditionClass objects to make cages
        ConditionClass conditionForLeons = new ConditionClass(availableForLeons);
        ConditionClass conditionForGiraffes = new ConditionClass(availableForGiraffes);
        // Make cages
        CageClass cageOne = new CageClass(conditionForLeons);
        CageClass cageTwo = new CageClass(conditionForGiraffes);

        // Make list of cages
        List<CageClass> cagesForZoo = new ArrayList<>();
        cagesForZoo.add(cageOne);
        cagesForZoo.add(cageTwo);
        // Make log
        List<InhibitionLog> logList = new ArrayList<>();
        // Make command reader and zoo with builder pattern
        ZooCommandReader reader = new ZooCommandReader(new ZooClass
                .ZooBuilder()
                .withCages(cagesForZoo)
                .withLog(logList)
                .build());
        // Start
        reader.start();
    }
}
