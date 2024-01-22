package units;

import java.util.Objects;

public class Weight {

    public enum Unit{
        MG, CG, G, KG;
    }

    private float value;

    private Unit unit;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Weight weight = (Weight) o;
        Weight convertedWeight = ((Weight) o).convertToCommonUnit(this.unit);
        return Float.compare(value, convertedWeight.value) == 0 && unit == convertedWeight.unit;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, unit);
    }

    public Weight(float value, Unit unit) {
        if(value<=0)
            throw new IllegalArgumentException();
        this.value = value;
        this.unit = unit;
    }

    public Weight convertToCommonUnit(Weight.Unit unit){
        Weight weightInG = this.convertToG();

        float weightForCommonUnit = switch (unit){
            case G ->  weightInG.value;
            case CG -> weightInG.value*100;
            case MG -> weightInG.value*1000;
            case KG -> weightInG.value / 1000;
        };

        return new Weight(weightForCommonUnit, unit);
    }

    public Weight convertToG(){
        float weightInG = switch (unit){
            case G -> value;
            case CG -> value/100;
            case MG -> value/1000;
            case KG -> value * 1000;
        };

        return new Weight(weightInG, Unit.G);
    }

    public Weight add(Weight weightToAdd){
        Weight convertedWeightToAdd = weightToAdd.convertToCommonUnit(this.unit);
        float addedLength = convertedWeightToAdd.value + this.value;
        return new Weight(addedLength, this.unit);
    }

    public int compareTo(Weight anotherWeight){
        Weight anotherWeightConverted = anotherWeight.convertToCommonUnit(this.unit);

        if(this.value > anotherWeightConverted.value)
            return 1;
        if(this.value < anotherWeightConverted.value)
            return -1;

        return 0;
    }
}
