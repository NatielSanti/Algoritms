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

class ClimbingTheLeaderboardResult {

    /*
     * Complete the 'climbingLeaderboard' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY ranked
     *  2. INTEGER_ARRAY player
     *
     * https://www.hackerrank.com/challenges/one-month-preparation-kit-climbing-the-leaderboard
     */

    public static List<Integer> climbingLeaderboard(List<Integer> ranked, List<Integer> player) {
        List<Integer> result = new ArrayList<>();
        Map<Integer,Integer> rankMap = new HashMap<>();
        int rank = 1;
        for(int i = 0; i < ranked.size(); i++){
            if(i > 0 && ranked.get(i) < ranked.get(i - 1)){
                rank++;
            }
            rankMap.put(ranked.get(i), rank);
        }
        for(Integer playerScore: player){
            for(int i = 0; i < ranked.size(); i++){
                if(playerScore >= ranked.get(i) && (i != ranked.size() - 1 || playerScore < ranked.get(i + 1))){
                    result.add(rankMap.get(ranked.get(i)));
                    break;
                }
                if(i == ranked.size() - 1 && playerScore < ranked.get(i)){
                    result.add(rankMap.get(ranked.get(i)) + 1);
                }
            }
        }

        return result;
    }

}

public class ClimbingTheLeaderboard {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int rankedCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> ranked = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int playerCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> player = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> result = ClimbingTheLeaderboardResult.climbingLeaderboard(ranked, player);

        System.out.println(result);

        bufferedReader.close();
    }
}
