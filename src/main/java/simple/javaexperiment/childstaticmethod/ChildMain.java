package main.java.simple.javaexperiment.childstaticmethod;

class ChildMain extends StaticAndNonstaticMethodExtend {
    @Override
    public void add(){
        System.out.println("Child add");
    }

    static void add2(){
        System.out.println("Child add2 static");
    }

    public void add3(){
        System.out.println("Child add3");
    }

    @Override
    public void method(){
        add();
        add2();
        super.method();
        System.out.println("Child method");
    }
}
