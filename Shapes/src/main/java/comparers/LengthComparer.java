package comparers;

public class LengthComparer {

    private String length1;
    private String length2;

    public LengthComparer(String length1, String length2) {
        if(!length1.endsWith("m") || !length2.endsWith("m"))
            throw new IllegalArgumentException();

        this.length1 = length1;
        this.length2 = length2;
    }

    public String compare(){
        return null;
    }

    public double covertToMeter(String length){
        String valueString = length.replaceAll("[^0-9.]","");
        double value = Double.parseDouble(valueString);

        if(length.contains("mm"))
            return value/1000;
        if(length.contains("cm"))
            return value/100;
        if(length.contains("km"))
            return value*1000;

        return value;

    }
}
