package lesson5;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Main {
    public static final int CARS_COUNT = 4;
    public static final CyclicBarrier startLine = new CyclicBarrier(CARS_COUNT);

    public static void main(String[] args) {
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Подготовка!!!");
        Race race = new Race(new Road(60), new Tunnel(CARS_COUNT), new Road(40));
        List<Callable<String>> cars = new ArrayList<>();
        for (int i = 0; i < CARS_COUNT; i++) {
            cars.add(new Car(race, 20 + (int) (Math.random() * 10), startLine));
        }
        ExecutorService service = Executors.newFixedThreadPool(CARS_COUNT);
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!");
        try {
            String winName = service.invokeAny(cars);
            System.out.println("Победитель: " + winName);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        service.shutdown();
        try {
            service.awaitTermination(2, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка закончилась!!!");
    }

}
