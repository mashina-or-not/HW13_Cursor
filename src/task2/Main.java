package task2;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(2);
        ExecutorService executor = Executors.newFixedThreadPool(5);
        List<Philosopher> allPhilosopher = List.of(
                new Philosopher("Ihor", semaphore),
                new Philosopher("Vlad", semaphore),
                new Philosopher("Vova", semaphore),
                new Philosopher("Sasha", semaphore),
                new Philosopher("Ivan", semaphore));

        for (Philosopher philosopher : allPhilosopher) {
            executor.execute(philosopher);
        }
        executor.shutdown();
    }
}
