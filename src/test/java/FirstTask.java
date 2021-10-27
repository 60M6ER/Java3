import lesson_6.Lesson6;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FirstTask {

    /**
     * Тесты по первому заданию
     */

    @Test
    public void testArray0Length() {
        Assertions.assertThrows(RuntimeException.class, () -> Lesson6.getArrayAfterLastFour(new int[0]));
    }

    @Test
    public void testArrayWithoutFour() {
        Assertions.assertThrows(RuntimeException.class, () -> Lesson6.getArrayAfterLastFour(new int[]{1, 2}));
    }

    @Test
    public void testArrayA() {
        Assertions.assertArrayEquals(new int[]{1, 7},
                Lesson6.getArrayAfterLastFour(new int[]{1, 2, 4, 4, 2, 3, 4, 1, 7}));
    }

    @Test
    public void testArrayB() {
        Assertions.assertArrayEquals(new int[0],
                Lesson6.getArrayAfterLastFour(new int[]{1, 2, 4, 4, 2, 3, 4}));
    }

    /**
     * Тесты по второму заданию
     */

    @Test
    public void test14A() {
        Assertions.assertTrue(Lesson6.testArray14(new int[]{1, 1, 1, 4, 4, 1, 4, 4}));
    }

    @Test
    public void test14B() {
        Assertions.assertFalse(Lesson6.testArray14(new int[]{1, 1, 1, 1, 1, 1}));
    }

    @Test
    public void test14C() {
        Assertions.assertFalse(Lesson6.testArray14(new int[]{4, 4, 4, 4}));
    }

    @Test
    public void test14D() {
        Assertions.assertFalse(Lesson6.testArray14(new int[]{1, 4, 4, 1, 1, 4, 3}));
    }
}
