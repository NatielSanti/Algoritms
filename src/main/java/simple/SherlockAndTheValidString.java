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

class SherlockAndTheValidStringResult {

    /*
     * Complete the 'isValid' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     * https://www.hackerrank.com/challenges/one-month-preparation-kit-sherlock-and-valid-string
     */

    public static String isValid(String s) {
        String[] arr = s.split("");
        Map<String, Integer> mapChar = new HashMap<>();
        for (String ch : arr) {
            mapChar.merge(ch, 1, Integer::sum);
        }

        Map<Integer, Integer> mapCount = new HashMap<>();
        for(Integer value :mapChar.values()){
            mapCount.merge(value, 1, Integer::sum);
        }

        boolean res = false;
        if(mapCount.size() > 2){
            res = false;
        } else if(mapCount.size() == 1){
            res = true;
        } else {
            boolean a = mapCount.keySet().stream().reduce(0, (x, y) -> Math.abs(y - x)) == 1;
            boolean b = mapCount.values().stream().filter(x -> x == 1).count() == 1;
            boolean c = mapCount.get(1) != null && mapCount.get(1) == 1;
            res = a && b || c;
        }
        return res ? "YES" : "NO";
    }

}

public class SherlockAndTheValidString {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String s = bufferedReader.readLine();

        String result = SherlockAndTheValidStringResult.isValid(s);

        System.out.println(result);

        bufferedReader.close();
    }
}
