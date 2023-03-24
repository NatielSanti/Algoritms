package simple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

class MatrixRotationAlgoResult {

    /*
     * Complete the 'matrixRotation' function below.
     *
     * The function accepts following parameters:
     *  1. 2D_INTEGER_ARRAY matrix
     *  2. INTEGER r
     *
     *
     * 4 4 1
        1 2 3 4
        5 6 7 8
        9 10 11 12
        13 14 15 16
     */

    public static void matrixRotation(List<List<Integer>> matrix, int r) {
        int m = matrix.size();
        int n = matrix.get(0).size();
        int layerCount = Math.min(n, m) / 2;

        List<List<Integer>> result = new ArrayList<>();
        for(int i = 0; i < matrix.size(); i++){
            result.add(new ArrayList<>(n));
        }

        System.out.println(n + " " + m + " " + layerCount);

        for(int i = 0; i < layerCount; i++){
            int perimeter = 2 * (n + m - 4 * i) - 4;
            int rotationCount = r % perimeter;
            int minX = 0 + i;
            int minY = 0 + i;
            int maxX = n - i - 1;
            int maxY = m - i - 1;
            int lengthX = maxX - minX + 1;
            int lengthY = maxY - minY + 1;

            int coorX = minX;
            int coorY = minY;
            int rotate = 0;
            int move = 0;

            for(int j = 0; j < perimeter; j++){
                coorX = minX; // fix
                coorY = minY; // fix
                rotate = rotationCount;
                // int curr = matrix.get(coorY).get(coorX);
                System.out.println("coor = " + coorX + " " + coorY + " rotate = " + rotate);
                while(rotate >= 0){
                    if(coorX == minX && coorY < maxY){
                        move = maxY - coorY;
                        if(rotate <= move){
                            coorY += move;
                        } else {
                            coorY = maxY;
                        }
                    } else if(coorY == maxY && coorX < maxX){
                        move = maxX - coorX;
                        if(rotate <= move){
                            coorX += move;
                        } else {
                            coorX = maxX;
                        }
                    } else if(coorX == maxX && coorY > minY){
                        move = coorY - minY;
                        if(rotate <= move){
                            coorY -= move;
                        } else {
                            coorY = minY;
                        }
                    } else if(coorY == minY && coorX > minX){
                        move = coorX - minX;
                        if(rotate <= move){
                            coorX -= move;
                        } else {
                            coorX = minX;
                        }
                    }
                    rotate -= move;
                }
                System.out.println("new value = " + coorX + " " + coorY);
            }



            System.out.println("perimeter = " + perimeter + " rotationCount = " + rotationCount + " maxmin " + minX + " " + maxX + " " + minY + " " + maxY + " len " + lengthX + " " + lengthY);
        }

    }

    private static void printMatrix(List<List<Integer>> matrix){
        int m = matrix.size();
        int n = matrix.get(0).size();

        for(int y = 0 ; y < m; y++){
            for(int x = 0; x < n; x++){
                if(x != 0){
                    System.out.print(" ");
                }
                System.out.print(matrix.get(y).get(x));
            }
            System.out.println("");
        }
    }

}

public class MatrixRotationAlgo {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int m = Integer.parseInt(firstMultipleInput[0]);

        int n = Integer.parseInt(firstMultipleInput[1]);

        int r = Integer.parseInt(firstMultipleInput[2]);

        List<List<Integer>> matrix = new ArrayList<>();

        IntStream.range(0, m).forEach(i -> {
            try {
                matrix.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        MatrixRotationAlgoResult.matrixRotation(matrix, r);

        bufferedReader.close();
    }
}

