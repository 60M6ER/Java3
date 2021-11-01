package lesson_7;

import lesson_7.annotations.AfterSuite;
import lesson_7.annotations.BeforeSuite;
import lesson_7.annotations.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Tester {

    public static void start(Class testClass) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException, InstantiationException {
        Method[] methods = testClass.getMethods();
        Method beforeSuite = null;
        Method afterSuite = null;
        boolean needObj = false;
        List<Method> tests = new ArrayList<>();
        for (int i = 0; i < methods.length; i++) {
            if (methods[i].getAnnotation(BeforeSuite.class) != null){
                if (beforeSuite != null)
                    throw new RuntimeException("@BeforeSuite more then 1");
                beforeSuite = methods[i];
            }
            if (methods[i].getAnnotation(AfterSuite.class) != null){
                if (afterSuite != null)
                    throw new RuntimeException("@AfterSuite more then 1");
                afterSuite = methods[i];
            }
            if (methods[i].getAnnotation(Test.class) != null){
                tests.add(methods[i]);
            }
            if (!Modifier.isStatic(methods[i].getModifiers())){
                needObj = true;
            }
        }

        tests.sort(Comparator.comparingInt(o -> o.getAnnotation(Test.class).priority()));

        Object objTest = null;
        if (needObj)
            objTest = testClass.getConstructor(null).newInstance();

        beforeSuite.invoke(objTest);

        for (int i = 0; i < tests.size(); i++) {
            tests.get(i).invoke(objTest);
        }

        afterSuite.invoke(objTest);
    }

    public static void main(String[] args) {
        try {
            start(SomeClass.class);
        } catch (InvocationTargetException | IllegalAccessException | NoSuchMethodException | InstantiationException e) {
            e.printStackTrace();
        }
    }
}
