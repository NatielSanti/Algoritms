package main.java.simple;

import java.util.*;

public class OneDArray {

    public static boolean canWin(int leap, int[] game) {
        int lastIndex = game.length - 1;
        int currIndex = 0;
        int next = 0;
        boolean moveForward = true;
        while(true){
            if(currIndex + leap >= lastIndex || currIndex + 1 >= lastIndex){
                return true;
            }
            if(game[currIndex] == -1){
                return false;
            }
            game[currIndex] = -1;
            next = game[currIndex + leap];
            if(next == 0){
                currIndex += leap;
                moveForward = true;
                continue;
            }
            next = game[currIndex + 1];
            if(next == 0 && moveForward){
                currIndex += 1;
                continue;
            }
            if(currIndex == 0){
                return false;
            }
            next = game[currIndex - 1];
            if(next == 0){
                currIndex -= 1;
                moveForward = false;
                continue;
            }
            return false;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int q = scan.nextInt();
        while (q-- > 0) {
            int n = scan.nextInt();
            int leap = scan.nextInt();

            int[] game = new int[n];
            for (int i = 0; i < n; i++) {
                game[i] = scan.nextInt();
            }

            System.out.println( (canWin(leap, game)) ? "YES" : "NO" );
        }
        scan.close();
    }
}