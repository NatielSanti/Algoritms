package simple.javaexperiment;

public class SingletonDoubleCheckBlock {
    private static class InstanceHolder {
        public static final SingletonDoubleCheckBlock INSTANCE = new SingletonDoubleCheckBlock();
    }
    public static SingletonDoubleCheckBlock getInstance() {
        return InstanceHolder.INSTANCE;
    }

    public static void main(String[] args) {
        System.out.println(InstanceHolder.INSTANCE == null);
    }

}
