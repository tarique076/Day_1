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

}
