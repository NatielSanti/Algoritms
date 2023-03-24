package simple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

class TimeConvertationResult {

    public static String timeConversion(String s) {
        String[] arr = s.split("");
        SimpleDateFormat formatterAm = new SimpleDateFormat("hh:mm:ss'AM'");
        SimpleDateFormat formatterPm = new SimpleDateFormat("hh:mm:ss'PM'");
        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");

        Date date = new Date();
        try {
            if (arr[arr.length - 2].equals("P")) {
                date = formatterPm.parse(s);
                date.setHours(date.getHours() + 12);
            } else
                date = formatterAm.parse(s);
        } catch (ParseException e) {
        }
        return formatter.format(date);
    }

}

public class TimeConvertation {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        System.out.println("Введите дату");
        String s = bufferedReader.readLine();

        String result = TimeConvertationResult.timeConversion(s);

        System.out.println(result);
//        bufferedWriter.write(result);
//        bufferedWriter.newLine();
//
//        bufferedReader.close();
//        bufferedWriter.close();
    }
}

