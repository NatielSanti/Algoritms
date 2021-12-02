package main.java.simple.javaexperiment;

public class MainStrings {
    public static void main(String[] args) {
        String a = "123" + 1;
        String b = new String("123" + 1);
        String c = newString1();
        String d = newString2("123");

        System.out.println(a == b);
        System.out.println(a == c);
        System.out.println(a == d);

        b = b.intern();

        System.out.println(a == b);
    }

    private static String newString1(){
        return "123" + 1;
    }

    private static String newString2(String s){
        return s + 1;
    }
}
