package main.java.simple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class CaesarCipherResult {

    /*
     * Complete the 'caesarCipher' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. STRING s
     *  2. INTEGER k
     */

    public static String caesarCipher(String s, int k) {
        k = k % 26;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] >= 65 && chars[i] <= 90) { // uppercase
                int item = chars[i] + k;
                if (item > 90)
                    chars[i] = (char) (item - 26);
                else
                    chars[i] = (char) item;
            } else if (chars[i] >= 97 && chars[i] <= 122) { // lowercase
                int item = chars[i] + k;
                if (item > 122)
                    chars[i] = (char) (item - 26);
                else
                    chars[i] = (char) item;
            }
        }
        return String.valueOf(chars);
    }

}

public class CaesarCipher {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        String s = bufferedReader.readLine();

        int k = Integer.parseInt(bufferedReader.readLine().trim());

        String result = CaesarCipherResult.caesarCipher(s, k);

        System.out.println(result);

        bufferedReader.close();
    }
}