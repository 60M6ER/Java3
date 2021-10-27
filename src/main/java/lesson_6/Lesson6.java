package lesson_6;

public class Lesson6 {
    public static void main(String[] args) {
        //int[] a = new int[0];
    }

    public static int[] getArrayAfterLastFour(int[] arrIn) {
        if (arrIn == null || arrIn.length < 1)
            throw new RuntimeException("Incoming array is null or its length is 0");
        int count = 0;
        int[] buffer = new int[arrIn.length];
        for (int i = arrIn.length - 1; i >= 0; i--) {
            if (arrIn[i] != 4) {
                buffer[count] = arrIn[i];
                count++;
            }else {
                int[] result = new int[count];
                for (int j = 0; j < result.length; j++) {
                    result[j] = buffer[count - 1 - j];
                }
                return result;
            }
        }
        throw new RuntimeException("Incoming array does not contain 4");
    }

    public static boolean testArray14(int[] arrIn) {
        if (arrIn == null) return false;
        boolean var1 = false, var4 = false;
        for (int i = 0; i < arrIn.length; i++) {
            if (arrIn[i] != 1 && arrIn[i] != 4)
                return false;
            if (arrIn[i] == 1) var1 = true;
            if (arrIn[i] == 4) var4 = true;
        }
        return var1 && var4;
    }
}
