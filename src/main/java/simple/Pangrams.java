package simple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

class PangramsResult {

    /*
     * Complete the 'miniMaxSum' function below.
     *
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static String pangrams(String s) {
        Set<String> set = new HashSet<>();
        String[] arr = s.toLowerCase().split("");
        for (String symbol : arr) {
            if (!symbol.equals(" "))
                set.add(symbol);
        }
        return set.size() == 26 ? "pangram" : "not pangram";
    }

}


public class Pangrams {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String s = bufferedReader.readLine();

        String result = PangramsResult.pangrams(s);
        System.out.println(result);
        bufferedReader.close();
    }
}
