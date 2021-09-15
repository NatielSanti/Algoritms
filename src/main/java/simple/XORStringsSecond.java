package main.java.simple;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class XORStringsSecond {

    public static String stringsXOR(String s, String t) {
        String res = new String("");
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == t.charAt(i))
                res += "0";
            else
                res += "1";
        }
        return res;
    }

    public static void main(String[] args) {

        String s, t;
        Scanner in = new Scanner(System.in);
        s = in.nextLine();
        t = in.nextLine();
        System.out.println(stringsXOR(s, t));

    }

    public static int flippingMatrix(List<List<Integer>> matrix) {
        for(int i = 0; i < matrix.size(); i++){
            List<Integer> integers = matrix.get(i);
            Integer reduce1 = integers.subList(0, matrix.size() / 2).stream().reduce(0, Integer::sum);
            Integer reduce2 = integers.subList(matrix.size() / 2, matrix.size()).stream().reduce(0, Integer::sum);
            System.out.println(reduce1 + " " + reduce2);
        }
        return 0;
    }

}


