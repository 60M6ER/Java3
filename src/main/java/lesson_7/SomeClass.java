package lesson_7;

import lesson_7.annotations.AfterSuite;
import lesson_7.annotations.BeforeSuite;
import lesson_7.annotations.Test;

public class SomeClass {

    @BeforeSuite
    public void beforeTest() {
        System.out.println("Метод до тестов");
    }

    @Test
    public void test1() {
        System.out.println("Тест 1");
    }

    @Test
    public void test2() {
        System.out.println("Тест 2");
    }

    @Test(priority = 3)
    public void test3() {
        System.out.println("Тест 3");
    }

    @Test(priority = 4)
    public void test4() {
        System.out.println("Тест 4");
    }

    @AfterSuite
    public void afterTest() {
        System.out.println("Метод после тестов");
    }
}
