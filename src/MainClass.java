import fruits.Apple;
import fruits.Box;
import fruits.Orange;

import java.util.ArrayList;

public class MainClass {
    public static void main(String[] args) {

    }

    /**
     * Метод меняет указанные элементы в масиве местами
     *
     * @return - возвращает ссылку массива с которым работал
     * @Param - в параметрах передаются массив, индексы элементов для свапа
     * */
    private static <T> T[] swapElements(T[] arr, int a, int b){
        if (Math.max(a, b) >= arr.length)
            throw new IndexOutOfBoundsException("В параметрах индексы выходят за рамки массива");
        T element = arr[a];
        arr[a] = arr[b];
        arr[b] = element;
        return arr;
    }

    private static <T> ArrayList<T> arrayToList(T[] arr) {
        ArrayList<T> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            list.add(arr[i]);
        }
        return list;
    }
}
