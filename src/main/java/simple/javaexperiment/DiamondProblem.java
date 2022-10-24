package simple.javaexperiment;

public class DiamondProblem {
    public static void main(String[] args) {

    }

    class Duck implements CanFly, CanSwim{
        // должен реализовать метод из-за проблемы diamond problem
        @Override
        public void move() {

        }
    }

    interface CanFly{
        default void move(){
            System.out.println("Fly!");
        }
    }

    interface CanSwim{
        default void move(){
            System.out.println("Swim!");
        }
    }
}
