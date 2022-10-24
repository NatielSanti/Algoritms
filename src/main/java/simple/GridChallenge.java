package simple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

class GridChallengeResult {

    /*
     * Complete the 'gridChallenge' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING_ARRAY grid as parameter.
     */

    public static String gridChallenge(List<String> grid) {
        List<List<Character>> characters = new ArrayList<>();
        for (int i = 0; i < grid.size(); i++) {
            List<Character> chars = Arrays.stream(grid.get(i).split(""))
                    .map(x -> x.charAt(0)).sorted().collect(toList());
            characters.add(chars);
            if (i != 0) {
                List<Character> last = characters.get(i - 1);
                for (int y = 0; y < chars.size(); y++) {
                    if (chars.get(y) < last.get(y)) {
                        return "NO";
                    }
                }
            }
        }
        return "YES";
    }

}

public class GridChallenge {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                List<String> grid = IntStream.range(0, n).mapToObj(i -> {
                    try {
                        return bufferedReader.readLine();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                })
                        .collect(toList());

                String result = GridChallengeResult.gridChallenge(grid);

                System.out.println(result);

            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
    }
}
