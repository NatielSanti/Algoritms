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

class HackerlandRadioTransmittersResult {

    /*
     * Complete the 'hackerlandRadioTransmitters' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY x
     *  2. INTEGER k
     *
     * 7 2
9 5 4 2 6 15 12
     */

    public static int hackerlandRadioTransmitters(List<Integer> x, int k) {
        if(x.size() == 1){
            return 1;
        }

        SortedSet<Integer> set = new TreeSet<>(x);
        Queue<Integer> queue = new PriorityQueue<>(set);

        int result = 1;
        int start = queue.poll();
        int curr = start;
        int prev = start;

        while(!queue.isEmpty()){
            prev = curr;
            curr = queue.poll();

        }

        return result;
    }

}

public class HackerlandRadioTransmitters {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int k = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> x = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int result = HackerlandRadioTransmittersResult.hackerlandRadioTransmitters(x, k);
        System.out.println("RESULT IS = " + result);

        bufferedReader.close();
    }
}

