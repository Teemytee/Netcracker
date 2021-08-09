import services.Condition;
import services.Species;

import java.util.List;

public class ConditionClass implements Condition {
    private List<Species> speciesList;

    public ConditionClass(List<Species> availableSpecies){
        this.speciesList = availableSpecies;
    }

    @Override
    public List<Species> isAvailableFor() {
        return this.speciesList;
    }


    public List<Species> getSpeciesList(){
        return this.speciesList;
    }
}
