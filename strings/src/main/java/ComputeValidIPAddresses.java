import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ComputeValidIPAddresses {

    /*
    7.10
    */

    public static List<String> computeValidIPAddresses(String s) {
        // TODO: Does not account for invalid IPs. Decimals should be between 0 and 255.
        if(s.length() < 4) {
            return null;
        }

        List<String> validIPs = new ArrayList<>();

        for(int i = 0; i < s.length() - 3; i++) {
            for(int j = i + 1; j < s.length() - 2; j ++) {
                for(int k = j + 1; k < s.length() - 1; k++) {
                    StringBuilder stringBuilder = new StringBuilder(s);
                    stringBuilder.insert(1 + i, '.');
                    stringBuilder.insert(2 + j, '.');
                    stringBuilder.insert(3 + k, '.');
                    validIPs.add(stringBuilder.toString());
                }
            }
        }

        return validIPs;
    }

}
