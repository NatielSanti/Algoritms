package simple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

class CountingSortFirstResult {

    /*
     * Complete the 'countingSort' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static List<Integer> countingSort(List<Integer> arr) {
        ArrayList<Integer> result = new ArrayList<>(Collections.nCopies(100, 0));
        for (Integer item : arr) {
            result.set(item, result.get(item) + 1);
        }
        return result;
    }

}

public class CountingSortFirst {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> result = CountingSortFirstResult.countingSort(arr);

        System.out.println(result.stream().map(x -> x + "").collect(Collectors.joining(" ")));
        bufferedReader.close();
    }
}
