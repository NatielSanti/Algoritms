package simple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

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
        Collections.sort(A);
        if(A.get(0) >= k){
            return 0;
        }

        int result = 0;
        int smallestIndex = 0;
        int secondSmallIndex = 0;
        int smallest = Integer.MAX_VALUE;
        int secondSmall = Integer.MAX_VALUE;
        int biggerIndex = A.size();
        for (int i = 0; i < biggerIndex; i++) {
            if(A.get(i) >= k){
                biggerIndex = i;
                break;
            }
        }

        while (true) {
            for (int i = 0; i < biggerIndex; i++) {
                int curr = A.get(i);
                if (curr < 0) {
                    continue;
                }
                if (curr < secondSmall) {
                    if (curr < smallest) {
                        secondSmall = smallest;
                        smallest = curr;
                        secondSmallIndex = smallestIndex;
                        smallestIndex = i;
                    } else {
                        secondSmall = curr;
                        secondSmallIndex = i;
                    }
                }
            }
            if (smallest >= k) {
                return result;
            } else if (secondSmall == Integer.MAX_VALUE) {
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

