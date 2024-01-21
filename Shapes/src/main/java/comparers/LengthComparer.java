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
        double value1 = covertToMeter(this.length1);
        double value2 = covertToMeter(this.length2);
        if(value1 > value2)
            return "Length1 "+ this.length1 + " is greater than length2 "+this.length2+ ".";

        if(value2 > value1)
            return "Length2 "+ this.length2 + " is greater than length1 "+this.length1+ ".";

        return "Length1 " +this.length1+ " is equal to length2 "+this.length2+".";
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
