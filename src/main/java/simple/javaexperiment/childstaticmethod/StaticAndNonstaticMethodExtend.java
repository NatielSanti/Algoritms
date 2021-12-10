package main.java.simple.javaexperiment.childstaticmethod;

public class StaticAndNonstaticMethodExtend {

    public static void main(String[] args) {
        StaticAndNonstaticMethodExtend main = new ChildMain();
        main.method();
        System.out.println("-----------");
        ChildMain childMain = new ChildMain();
        childMain.method();

    }

    public synchronized void add(){
        System.out.println("Parent add");
    } // haha overrite failed! Child not thread safe!

    static void add2(){
        System.out.println("Parent add2 static");
    }

    public void method(){
        add();
        add2();
        System.out.println("Parent method");
    }


}
