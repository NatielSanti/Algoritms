package main.java.simple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.IntStream;

class BalancedBracketsResult {

    /*
     * Complete the 'isBalanced' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     *
     * https://www.hackerrank.com/challenges/one-month-preparation-kit-balanced-brackets
     */

    public static String isBalanced(String s) {
//        {, }, (, ), [, ]
        System.out.println("START ANALYSE: " + s);
        String[] split = s.split("");
        int end = split.length - 1;
        for (int start = 0; start < end; start++) {
             if (compareSymbols(split, start, start + 1)) {
                System.out.println("start++ ");
                start++;
            } else if (compareSymbols(split, end - 1, end)) {
                System.out.println("end - 2 ");
                end = end - 2;
                start--;
            } else if (compareSymbols(split, start, end)) {
                System.out.println("end-- ");
                end--;
            } else
                return "NO";
        }
        return "YES";
    }

    private static boolean compareSymbols(String[] split, int firstIndex, int secondIndex){
        System.out.println("iter: " + split[firstIndex] + " " + split[secondIndex]);
        return (split[firstIndex].equals("{") && split[secondIndex].equals("}")) ||
                (split[firstIndex].equals("(") && split[secondIndex].equals(")")) ||
                (split[firstIndex].equals("[") && split[secondIndex].equals("]"));
    }

}

public class BalancedBrackets {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                String s = bufferedReader.readLine();

                String result = BalancedBracketsResult.isBalanced(s);

                System.out.println(result);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
    }
}