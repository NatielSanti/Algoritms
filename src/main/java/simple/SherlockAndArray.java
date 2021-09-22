package main.java.simple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

class SherlockAndArrayResult {

    /*
     * Complete the 'balancedSums' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts INTEGER_ARRAY arr as parameter.
     *
     * https://www.hackerrank.com/challenges/one-month-preparation-kit-sherlock-and-array
     */

    public static String balancedSums(List<Integer> arr) {
        final int total = arr.stream().reduce(0, Integer::sum);
        int sum = 0;
        String result = "NO";
        for(Integer element:arr){
            sum+=element;
            if(sum-element==total-sum){
                result = "YES";
                break;
            }
        }
        return result;
    }

}

public class SherlockAndArray {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, T).forEach(TItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList());

                String result = SherlockAndArrayResult.balancedSums(arr);

                System.out.println(result);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
    }
}