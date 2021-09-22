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

class SumVsXORResult {

    /*
     * Complete the 'sumXor' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts LONG_INTEGER n as parameter.
     *
     * https://www.hackerrank.com/challenges/one-month-preparation-kit-sum-vs-xo
     */

    public static long sumXor(long n) {
        int result = 0;
        long sum = n;
        for(long i = 0; i <= n; i++){
            if((sum + 1) == (n ^ i))
                result++;
        }
        return result;
    }

}

public class SumVsXOR {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        long n = Long.parseLong(bufferedReader.readLine().trim());

        long result = SumVsXORResult.sumXor(n);

        bufferedReader.close();

        System.out.println(result);
    }
}
