package simple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLOutput;
import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

class NewYearChaosResult {

    /*
     * Complete the 'minimumBribes' function below.
     *
     * The function accepts INTEGER_ARRAY q as parameter.
     *
     *
2
5
2 1 5 3 4
5
2 5 1 3 4
     */

    private static Map<Integer, Integer> brideCount;

    public static void minimumBribes(List<Integer> q) {
        if(q.size() == 0 || q.size() == 1){
            System.out.println(0);
            return;
        }

        brideCount = new HashMap<>();

        int result = 0;
        int curr = 0;
        int next = 0;
        int buffer = 0;
        int startIndex = 1;
        int nextIndex = 1;
        int lastIndex = q.size();
        boolean notChaotic = true;

        while(notChaotic && startIndex != lastIndex){
            nextIndex = startIndex;
            curr = q.get(nextIndex - 1);
            next = q.get(nextIndex);
            startIndex++;
            while(curr > next){
                if(isBride(nextIndex - 1, nextIndex)){
                    buffer = next;
                    next = q.set(nextIndex - 1, curr);
                    curr = q.set(nextIndex, buffer);
                    result++;
                } else {
                    notChaotic = false;
                }
                nextIndex--;
                if(nextIndex > 0){
                    curr = q.get(nextIndex - 1);
                    next = q.get(nextIndex);
                } else {
                    break;
                }
            }
        }
        if(notChaotic){
            System.out.println(result / 2);
        } else {
            System.out.println("Too chaotic");
        }

    }

    private static boolean isBride(int curr, int next){
        return isBride(curr) || isBride(next);
    }

    private static boolean isBride(int curr){
        Integer currBride = brideCount.get(curr);
        if(currBride == null){
            brideCount.put(curr, 1);
            return true;
        }
        else if(currBride < 2){
            brideCount.put(curr, currBride + 1);
            return true;
        } else {
            return false;
        }
    }
}

public class NewYearChaos {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                List<Integer> q = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList());

                NewYearChaosResult.minimumBribes(q);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
    }
}
