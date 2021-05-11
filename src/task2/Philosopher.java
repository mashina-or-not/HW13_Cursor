package task2;

import java.util.concurrent.Semaphore;

public class Philosopher implements Runnable {
    private final String name;
    private final Semaphore semaphore;

    public Philosopher(String name, Semaphore semaphore) {
        this.name = name;
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        try {
            semaphore.acquire();
            System.out.printf("The philosopher %s sat dawn at the table\n", name);
            Thread.sleep(2000);
            System.out.printf("The philosopher %s got up from the table\n", name);
            semaphore.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
