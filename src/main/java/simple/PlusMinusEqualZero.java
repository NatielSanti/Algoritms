package simple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

class PlusMinusEqualZeroResult {

    /*
     * Complete the 'plusMinus' function below.
     *
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static void plusMinus(List<Integer> arr) {
        if (arr == null || arr.size() == 0)
            System.out.println("0.000000 \n 0.000000 \n 0.000000");
//        int less = 0;
//        int equal = 0;
//        int great = 0;
//        for (Integer item : arr) {
//            if(item < 0)
//                less ++;
//            else if(item > 0)
//                great ++;
//            else
//                equal++;
//        }
//        String sLess = new DecimalFormat("#0.000000").format((double) less / arr.size());
//        String sEqual = new DecimalFormat("#0.000000").format((double) equal / arr.size());
//        String sGreat = new DecimalFormat("#0.000000").format((double) great / arr.size());
//        System.out.println(sLess);
//        System.out.println(sEqual);
//        System.out.println(sGreat);
    }

}

public class PlusMinusEqualZero {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        PlusMinusEqualZeroResult.plusMinus(arr);

        bufferedReader.close();
    }
}

