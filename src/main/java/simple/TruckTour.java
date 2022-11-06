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


class TruckTourResult {

    /*
     * Complete the 'truckTour' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts 2D_INTEGER_ARRAY petrolpumps as parameter.
     *
     * 3
1 5
10 3
3 4
*
* out
* 1
     */

    public static int truckTour(List<List<Integer>> petrolpumps) {
        for(int i = 0; i < petrolpumps.size(); i++){
            if(isCicle(petrolpumps, i)){
                return i;
            }
        }
        return -1;
    }

    private static boolean isCicle(List<List<Integer>> petrolpumps, int i){
        int gaz = 0;
        int curr = i;
        List<Integer> pump;
        int next = i == petrolpumps.size() - 1 ? 0 : i + 1;
        while(gaz >= 0){
            pump = petrolpumps.get(curr);
            gaz += pump.get(0) - pump.get(1);
            curr = curr + 1 == petrolpumps.size() ? 0 : curr + 1;
            if(curr == i){
                return true;
            }
        }
        return false;
    }

}
public class TruckTour {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<Integer>> petrolpumps = new ArrayList<>();

        IntStream.range(0, n).forEach(i -> {
            try {
                petrolpumps.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int result = TruckTourResult.truckTour(petrolpumps);

        System.out.println("RESULT IS = " + result);

        bufferedReader.close();
    }
}

