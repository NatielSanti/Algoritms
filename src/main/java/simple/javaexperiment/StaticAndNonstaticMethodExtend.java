package main.java.simple.javaexperiment;

import java.util.Comparator;

public class StaticAndNonstaticMethodExtend {

    public static void main(String[] args) {
        StaticAndNonstaticMethodExtend main = new ChildMain();
        main.method();
        System.out.println("-----------");
        ChildMain childMain = new ChildMain();
        childMain.method();

    }

    public void add(){
        System.out.println("Parent add");
    }

    static void add2(){
        System.out.println("Parent add2 static");
    }

    public void method(){
        add();
        add2();
        System.out.println("Parent method");
    }


}
