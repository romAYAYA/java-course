package Object.toString.task1;

import java.util.Arrays;

public class Address {
    public String city;
    public String street;
    public int houseNumber;
    public String extraInfo;
    public String[] residents;

    @Override
    public String toString() {
        String result = "Address{" +
                "city='" + city + '\'' +
        ", street='" + street + '\'' +
        ", houseNumber=" + houseNumber + '\'';

        if (extraInfo != null) {
            result = result + ", extraInfo.length=" + extraInfo.length();
        } else {
            result = result + ", extraInfo=null";
        }

        return result + ", residents=" + Arrays.toString(residents) + '}';
    }
}

