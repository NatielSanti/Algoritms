package main.java.simple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;


class MatrixFlipGameResult {

    /*
     * Complete the 'flippingMatrix' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts 2D_INTEGER_ARRAY matrix as parameter.
     */

    public static int flippingMatrix(List<List<Integer>> matrix) {
        for (int i = 0; i < matrix.size(); i++) {
            List<Integer> integers = matrix.get(i);
            Integer reduce1 = integers.subList(0, matrix.size() / 2).stream().reduce(0, Integer::sum);
            Integer reduce2 = integers.subList(matrix.size() / 2, matrix.size()).stream().reduce(0, Integer::sum);
            if (reduce1 < reduce2)
                Collections.reverse(integers);
        }
        int result = 0;
        List<Integer> firstPart = new ArrayList<>(Collections.nCopies(matrix.size() / 2, 0));
        List<Integer> secondPart = new ArrayList<>(Collections.nCopies(matrix.size() / 2, 0));
        for (int i = 0; i < matrix.size(); i++) {
            int res1 = 0;
            int res2 = 0;
            for (int y = 0; y < matrix.size() / 2; y++) {
//                1 2 3 4
//                2 3 4 5
//                3 4 5 6
//                4 5 6 7
                if (i < matrix.size() / 2)
                    firstPart.set(y, firstPart.get(y) + matrix.get(i).get(y));
                else
                    secondPart.set(y, secondPart.get(y) + matrix.get(i).get(y));
            }
        }
        for (int i = 0; i < firstPart.size(); i++) {
            result += Math.max(firstPart.get(i), secondPart.get(i));
        }
        return result;
    }

}

public class MatrixFlipGame {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                List<List<Integer>> matrix = new ArrayList<>();

                IntStream.range(0, 2 * n).forEach(i -> {
                    try {
                        matrix.add(
                                Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                        .map(Integer::parseInt)
                                        .collect(toList())
                        );
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                });

                int result = MatrixFlipGameResult.flippingMatrix(matrix);
                System.out.println(result);

            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
    }
}

