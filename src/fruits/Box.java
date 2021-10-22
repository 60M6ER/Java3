package fruits;

import java.util.ArrayList;

public class Box<T extends Fruit> {
    private ArrayList<T> fruits;

    public Box() {
        fruits = new ArrayList<>();
    }

    public double getWeight() {
        double sum = 0.0;
        for (int i = 0; i < fruits.size(); i++) {
            sum += fruits.get(i) == null ? 0.0 : fruits.get(i).getWeight();
        }
        return sum;
    }

    public boolean compare(Box<?> another) {
        return Double.compare(this.getWeight(), another.getWeight()) == 0;
    }

    public void transferFruits(Box<T> fruits, int count) {
        if (count > this.fruits.size())
            throw new IndexOutOfBoundsException(
                    String.format("В текущей коробке не достаточно фруктов для пересыпания %s фруктов",
                    count)
            );

        for (int i = 0; i < count; i++) {
            fruits.addFruit(this.fruits.get(this.fruits.size() - 1 - i));
            this.fruits.remove(this.fruits.size() - 1 - i);
        }
    }

    public void addFruit(T fruit){
        fruits.add(fruit);
    }
}
