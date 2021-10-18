package lesson_4;

public class LessonFour {

    private int a = 65;

    public static void main(String[] args) {
        new LessonFour();
    }

    private synchronized void print(char out) {
        while (a != (int) out) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.print(out);
        a++;
        if (a > 67) a = 65;
        notifyAll();
    }

    private LessonFour() {
        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                print('A');
            }
        }).start();
        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                print('B');
            }
        }).start();
        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                print('C');
            }
        }).start();
    }
}
