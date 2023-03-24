package main.java.simple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

class MiniMaxSumResult {

    /*
     * Complete the 'miniMaxSum' function below.
     *
     * The function accepts INTEGER_ARRAY arr as parameter.
     *
     * 1 2 3 4 5 -> 10 14
     */

    public static void miniMaxSum(List<Integer> arr) {
        int min = arr.stream().min(Integer::compare).orElse(0);
        int max = arr.stream().max(Integer::compare).orElse(0);
        int sum = arr.stream().reduce(0, Integer::sum);
        System.out.println((sum - max) + " " + (sum - min));
    }

}

public class MiniMaxSum {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        MiniMaxSumResult.miniMaxSum(arr);

        bufferedReader.close();
    }
}
