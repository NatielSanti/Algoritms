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
     */

    public static void minimumBribes(List<Integer> q) {
        if(q.size() == 0 || q.size() == 1){
            System.out.println(0);
            return;
        }
        int result = 0;
        int major = -1;
        int jerry = 0;
        for(int i = 1; i < q.size();){
            if(q.get(i) < q.get(i - 1)){
                if((jerry!= 0 && jerry - i > 2) ||
                    (major!= -1 && i - major > 2)) {
                    System.out.println("Too chaotic");
                    return;
                }
                int curr = q.get(i);
                q.remove(i);
                q.add(i - 1, curr);
                result ++;
                if(jerry == 0)
                    jerry = i;
                if(major == -1)
                    major = i - 1;
                if(i > 1)
                    i--;
            } else {
                if(i <= jerry){
                    jerry = 0;
                }
                if(i - major == 3)
                    major = -1;
                i++;
            }
        }
        System.out.println(result);
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
