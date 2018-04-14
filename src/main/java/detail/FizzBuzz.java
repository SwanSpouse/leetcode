package detail;

import java.util.ArrayList;
import java.util.List;

public class FizzBuzz {
    public List<String> fizzBuzz(int n) {
        String multi3 = "Fizz";
        String multi5 = "Buzz";
        String multi3And5 = "FizzBuzz";

        ArrayList<String> ret = new ArrayList<String>();
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                ret.add(multi3And5);
            } else if (i % 3 == 0) {
                ret.add(multi3);
            } else if (i % 5 == 0) {
                ret.add(multi5);
            } else {
                ret.add(i + "");
            }
        }
        return ret;
    }
}
