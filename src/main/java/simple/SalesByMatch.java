package simple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

class SalesByMatchResult {

    /*
     * Complete the 'sockMerchant' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER_ARRAY ar
     */

    public static int sockMerchant(int n, List<Integer> ar) {
        int result = 0;
        for (int i = 0; i < ar.size(); i++) {
            int item = ar.get(i);
            for (int y = i + 1; y < ar.size(); y++) {
                int temp = ar.get(y);
                if (item == temp) {
                    ar.remove(i);
                    ar.remove(y - 1);
                    i--;
                    result++;
                    break;
                }
            }
        }
        return result;
    }

}

public class SalesByMatch {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> ar = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int result = SalesByMatchResult.sockMerchant(n, ar);
        System.out.println("result = " + result);

        bufferedReader.close();
    }
}