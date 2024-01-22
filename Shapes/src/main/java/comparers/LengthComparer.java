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
        double value1 = convertToMeter(this.length1);
        double value2 = convertToMeter(this.length2);
        if(value1 > value2)
            return "Length1 "+ this.length1 + " is greater than length2 "+this.length2+ ".";

        if(value2 > value1)
            return "Length2 "+ this.length2 + " is greater than length1 "+this.length1+ ".";

        return "Length1 " +this.length1+ " is equal to length2 "+this.length2+".";
    }

    public double convertToMeter(String length){
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

    public double convertTomm(String length){
        String valueString = length.replaceAll("[^0-9.]","");
        double value = Double.parseDouble(valueString);

        if(length.contains("cm"))
            return value*10;
        if(length.contains("km"))
            return value*1000*1000;
        if(length.contains("mm"))
            return value;

        return value*1000;


    }

    public double convertTocm(String length){
        String valueString = length.replaceAll("[^0-9.]","");
        double value = Double.parseDouble(valueString);

        if(length.contains("mm"))
            return value/10;
        if(length.contains("km"))
            return value*1000*100;
        if(length.contains("cm"))
            return value;

        return value*100;
    }

    public double convertTokm(String length){
        String valueString = length.replaceAll("[^0-9.]","");
        double value = Double.parseDouble(valueString);

        if(length.contains("mm"))
            return value/1000000;
        if(length.contains("km"))
            return value;
        if(length.contains("cm"))
            return value/100000;

        return value/1000;
    }

    public String add(){
        if(length2.contains("mm")){
            double finalLength = convertTomm(this.length1) + convertTomm(this.length2);
            return finalLength+"mm";
        }
        if(length2.contains("cm")){
            double finalLength = convertTocm(this.length1) + convertTocm(this.length2);
            return finalLength+"cm";
        }
        if(length2.contains("km")){
            double finalLength = convertTokm(this.length1) + convertTokm(this.length2);
            return finalLength+"km";
        }

        double finalLength = convertToMeter(this.length1) + convertToMeter(this.length2);
        return finalLength+"m";
    }

    public String subtract(){
        return null;
    }
}
