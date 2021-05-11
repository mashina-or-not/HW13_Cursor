package task1;

public class Main {
    public static void main(String[] args) {
        Thread chickenThread = new Thread(new Chicken());
        Eggs eggs = new Eggs();

        chickenThread.start();
        eggs.run();

        if (chickenThread.isAlive()) {
            try {
                chickenThread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("*The chicken was the first*");
        } else {
            System.out.println("*The egg was the first*");
        }
    }
}
