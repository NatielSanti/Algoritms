package main.java.simple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

class MaxMinResult {

    /*
     * Complete the 'maxMin' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER k
     *  2. INTEGER_ARRAY arr
     */

    public static int maxMin(int k, List<Integer> arr) {
        Collections.sort(arr);
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < arr.size() - k + 1; i++) {
            List<Integer> sublist = arr.subList(i, Math.min(i + k , arr.size()));
            int tempMin = sublist.get(sublist.size() - 1) - sublist.get(0);
            if(tempMin < result)
                result = tempMin;
        }
        return result;
    }

}

public class MaxMin {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        int k = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = IntStream.range(0, n).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(toList());

        int result = MaxMinResult.maxMin(k, arr);

        System.out.println(result);

        bufferedReader.close();
    }
}
