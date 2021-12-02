package main.java.simple.javaexperiment;

public class TypeErasionSecond<T> {

    private T value1;
    private T value2;

    public void printValues() {
        System.out.println(value1);
        System.out.println(value2);
    }

    public static <T> TypeErasionSecond<T> createAndAdd2Values(Object o1, Object o2) {
        TypeErasionSecond<T> result = new TypeErasionSecond<>();
        result.value1 = (T) o1;
        result.value2 = (T) o2;
        return result;
    }

    public static void main(String[] args) {
        Double d = 22.111;
        String s = "Test String";
        TypeErasionSecond<Integer> test = createAndAdd2Values(d, s);
        test.printValues();
    }
}