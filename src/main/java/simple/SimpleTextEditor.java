package main.java.simple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

//        Implement a simple text editor. The editor initially contains an empty string, . Perform  operations of the following  types:
//
//        append - Append string  to the end of .
//        delete - Delete the last  characters of .
//        print - Print the  character of .
//        undo - Undo the last (not previously undone) operation of type  or , reverting  to the state it was in prior to that operation.
//
//        operation
//        index   S       ops[index]  explanation
//        -----   ------  ----------  -----------
//        0       abcde   1 fg        append fg
//        1       abcdefg 3 6         print the 6th letter - f
//        2       abcdefg 2 5         delete the last 5 letters
//        3       ab      4           undo the last operation, index 2
//        4       abcdefg 3 7         print the 7th characgter - g
//        5       abcdefg 4           undo the last operation, index 0
//        6       abcde   3 4         print the 4th character - d

public class SimpleTextEditor {

    private static int numberOfOperation;
    private static String str = "";
    private static List<String> history = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT.
        Your class should be named Solution. */

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        numberOfOperation = Integer.parseInt(reader.readLine());
        String line;

        while ((line = reader.readLine()) != null && numberOfOperation > 0) {
            // System.out.println("Current val BEFORE " + str + " " + line);
            numberOfOperation--;
            String[] lineArr = line.split(" ");
            if (lineArr.length == 1 || lineArr.length == 2
                    || !lineArr.equals("1") || !lineArr.equals("2")
                    || !lineArr.equals("3") || !lineArr.equals("4")) {
                int command = Integer.parseInt(lineArr[0].trim());
                if (command == 1 && lineArr.length == 2 && lineArr[1] != null) {
                    append(lineArr[1]);
                } else if (command == 2 && lineArr.length == 2 && lineArr[1] != null) {
                    int index = Integer.parseInt(lineArr[1]);
                    if (index < 0 && index > str.length()) {
                        throw new RuntimeException("We got o big delete index");
                    }
                    delete(index);
                } else if (command == 3 && lineArr.length == 2 && lineArr[1] != null) {
                    int index = Integer.parseInt(lineArr[1]);
                    if (index < 0 && index > str.length()) {
                        throw new RuntimeException("We got to big delete index");
                    }
                    print(index);
                } else if (command == 4 && lineArr.length == 1) {
                    undo();
                } else {
                    throw new RuntimeException("Too bad input");
                }
            }
            // System.out.println("Current val AFTER " + str);
        }
    }

    private static void append(String newLine) {
        history.add(str);
        str += newLine;
    }

    private static void delete(int index) {
        history.add(str);
        str = str.substring(0, str.length() - index);
    }

    private static void print(int index) {
        System.out.println(str.charAt(index - 1));
    }

    private static void undo() {
        String oldStr = history.get(history.size() - 1);
        str = oldStr;
        history.remove(history.size() - 1);
    }

}
