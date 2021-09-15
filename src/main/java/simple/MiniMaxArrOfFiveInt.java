package main.java.simple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

class MiniMaxArrOfFiveIntResult {

    /*
     * Complete the 'miniMaxSum' function below.
     *
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static void miniMaxSum(List<Integer> arr) {
        arr = arr.stream().sorted().collect(toList());
        long sum = 0;
        for (int item: arr)
            sum += item;
        System.out.println( (sum - arr.get(arr.size() - 1)) + " " + (sum - arr.get(0)) );
    }

}


public class MiniMaxArrOfFiveInt {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        MiniMaxArrOfFiveIntResult.miniMaxSum(arr);

        bufferedReader.close();
    }
}
