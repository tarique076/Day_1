package units;

import java.util.Objects;

public class Length {

    public enum Unit{
        MM, CM, M, KM;
    }

    private float value;

    private Unit unit;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Length length = (Length) o;
        Length convertedLength = ((Length) o).convertToCommonUnit(this.unit);
        System.out.println(this.value+" "+ convertedLength.value + " "+this.unit+" "+convertedLength.unit);
        return convertedLength.value == this.value && convertedLength.unit == this.unit;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, unit);
    }

    public Length(float value, Unit unit) {
        if(value<=0)
            throw new IllegalArgumentException();
        this.value = value;
        this.unit = unit;
    }

    public Length convertToCommonUnit(Unit unit){
        Length lengthInM = this.convertToM();

        float lengthForCommonUnit = switch (unit){
            case M ->  lengthInM.value;
            case CM -> lengthInM.value*100;
            case MM -> lengthInM.value*1000;
            case KM -> lengthInM.value / 1000;
        };

        return new Length(lengthForCommonUnit, unit);
    }

    public Length convertToM(){
        float lengthInM = switch (unit){
            case M -> value;
            case CM -> value/100;
            case MM -> value/1000;
            case KM -> value * 1000;
        };

        return new Length(lengthInM, Unit.M);
    }

    public Length add(Length lengthToAdd){
        Length convertedLengthToAdd = lengthToAdd.convertToCommonUnit(this.unit);
        float addedLength = convertedLengthToAdd.value + this.value;
        return new Length(addedLength, this.unit);
    }

    public int compareTo(Length anotherLength){
        Length anotherLengthConverted = anotherLength.convertToCommonUnit(this.unit);

        if(this.value > anotherLengthConverted.value)
            return 1;
        if(this.value < anotherLengthConverted.value)
            return -1;

        return 0;
    }
}
