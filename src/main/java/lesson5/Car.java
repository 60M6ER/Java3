package lesson5;

import java.util.concurrent.Callable;
import java.util.concurrent.CyclicBarrier;

public class Car implements Callable<String> {
    private static int CARS_COUNT;
    private Race race;
    private int speed;
    private String name;
    private CyclicBarrier startLine;

    public String getName() {
        return name;
    }
    public int getSpeed() {
        return speed;
    }
    public Car(Race race, int speed, CyclicBarrier startLine) {
        this.race = race;
        this.speed = speed;
        CARS_COUNT++;
        this.name = "Участник #" + CARS_COUNT;
        this.startLine = startLine;
    }

    @Override
    public String call() throws Exception {
        try {
            System.out.println(this.name + " готовится");
            Thread.sleep(500 + (int)(Math.random() * 800));
            System.out.println(this.name + " готов");
            startLine.await();
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (int i = 0; i < race.getStages().size(); i++) {
            race.getStages().get(i).go(this);
        }
        return name;
    }

//    @Override
//    public void run() {
//        try {
//            System.out.println(this.name + " готовится");
//            Thread.sleep(500 + (int)(Math.random() * 800));
//            System.out.println(this.name + " готов");
//            startLine.await();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        for (int i = 0; i < race.getStages().size(); i++) {
//            race.getStages().get(i).go(this);
//        }
//    }

}
