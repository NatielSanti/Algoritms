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

class JesseAndCookiesResult {

    /*
     * Complete the 'cookies' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER k
     *  2. INTEGER_ARRAY A
     *
     * 6 7
1 2 3 9 10 12
     */

    public static int cookies(int k, List<Integer> A) {
        int result = 0;
        int smallestIndex = 0;
        int secondSmallIndex = 0;
        int smallest = Integer.MAX_VALUE;
        int secondSmall = Integer.MAX_VALUE;

        while(true){
            System.out.println("iter = " + result);
            for (int i = 0; i < A.size(); i++) {
                int curr = A.get(i);
                if( curr < 0){
                    continue;
                }
                if(curr < secondSmall){
                    if(curr < smallest){
                        secondSmall= smallest;
                        smallest = curr;
                        secondSmallIndex = smallestIndex;
                        smallestIndex = i;
                    } else {
                        secondSmall = curr;
                        secondSmallIndex = i;
                    }
                }
            }
            if(smallest >= k){
                return result;
            } else if(secondSmall == Integer.MAX_VALUE){
                return -1;
            } else {
                result++;
                A.set(smallestIndex, smallest + secondSmall * 2);
                A.set(secondSmallIndex, -1);
            }
            smallest = Integer.MAX_VALUE;
            secondSmall = Integer.MAX_VALUE;
        }

    }

}

public class JesseAndCookies {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int k = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> A = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int result = JesseAndCookiesResult.cookies(k, A);
        System.out.println("RESULT IS = " + result);
        bufferedReader.close();
    }
}

