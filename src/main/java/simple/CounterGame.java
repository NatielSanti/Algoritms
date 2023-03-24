package simple;

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

class CounterGameResult {

    /*
     * Complete the 'counterGame' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts LONG_INTEGER n as parameter.
     */

    public static String counterGame(long n) {
        double balance = n;
        double buff;
        int degree;

        while(balance > 0){
            degree = getDegree(balance);
            buff = Math.pow(2, degree);
            balance = balance - buff;
        }

        return balance == 0 ? "Richard": "Louise";
    }

    private static int getDegree(double n){
        int degree = 0;
        double buff = 1;
        while(buff <= n / 2){
            degree++;
            buff = buff * 2;
        }
        return degree;
    }

}

public class CounterGame {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                long n = Long.parseLong(bufferedReader.readLine().trim());

                String result = CounterGameResult.counterGame(n);

                System.out.println();
                System.out.println(result);

            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
    }
}
