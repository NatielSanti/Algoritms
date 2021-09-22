package main.java.simple;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class RecursiveDigitSumResult {

    /*
     * Complete the 'superDigit' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. STRING n
     *  2. INTEGER k
     *
     * https://www.hackerrank.com/challenges/one-month-preparation-kit-recursive-digit-sum
     */

    public static int superDigit(String n, int k) {
        if(k == 1)
            return Integer.parseInt(n);
        int result = 0;
        for(String ch: n.split("")){
            result += Integer.parseInt(ch);
        }
        return superDigit(result+"", (result+"").length());
    }

}

public class RecursiveDigitSum {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        String n = firstMultipleInput[0];

        int k = Integer.parseInt(firstMultipleInput[1]);

        int result = RecursiveDigitSumResult.superDigit(n, k);

        System.out.println(result);

        bufferedReader.close();
    }
}
