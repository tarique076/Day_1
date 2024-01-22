package units;

import java.util.Objects;

public class Volume {

    public enum Unit{
        ML, CL, L, KL;
    }

    private float value;

    Unit unit;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Volume volume = (Volume) o;
        Volume convertedVolume = ((Volume) o).convertToCommonUnit(this.unit);
        return Float.compare(value, convertedVolume.value) == 0 && unit == convertedVolume.unit;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, unit);
    }

    public Volume(float value, Unit unit) {
        if(value<=0){
            throw new IllegalArgumentException();
        }
        this.value = value;
        this.unit = unit;
    }

    public Volume convertToCommonUnit(Volume.Unit unit){
        Volume volumeInL = this.convertToL();

        float weightForCommonUnit = switch (unit){
            case L ->  volumeInL.value;
            case CL -> volumeInL.value*100;
            case ML -> volumeInL.value*1000;
            case KL -> volumeInL.value / 1000;
        };

        return new Volume(weightForCommonUnit, unit);
    }

    public Volume convertToL(){
        float weightInG = switch (unit){
            case L -> value;
            case CL -> value/100;
            case ML -> value/1000;
            case KL -> value * 1000;
        };

        return new Volume(weightInG, Unit.L);
    }

    public Volume add(Volume volumeToAdd){
        Volume convertedVolumeToAdd = volumeToAdd.convertToCommonUnit(this.unit);
        float addedLength = convertedVolumeToAdd.value + this.value;
        return new Volume(addedLength, this.unit);
    }

    public int compareTo(Volume anotherVolume){
        Volume anotherVolumeConverted = anotherVolume.convertToCommonUnit(this.unit);

        if(this.value > anotherVolumeConverted.value)
            return 1;
        if(this.value < anotherVolumeConverted.value)
            return -1;

        return 0;
    }
}
