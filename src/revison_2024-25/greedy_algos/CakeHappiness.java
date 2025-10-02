package greedy_algos;

import java.util.ArrayList;
import java.util.Comparator;

/*
* Consider you go to a cake shop to get some cakes. Each cake has some weight and also a
* happiness value associated with it.
* Now you have been given weight W. You have to pick the cakes such that combined weight
* won't be more than W and maximize happiness.
*
*
* */
public class CakeHappiness {
    public static void main(String[] args) {
        ArrayList<Cake> cakes = new ArrayList<>();
        cakes.add(new Cake("A", 70, 10));
        cakes.add(new Cake("B", 40, 20));
        cakes.add(new Cake("C", 25, 5));
        cakes.add(new Cake("D", 49, 7));
        cakes.add(new Cake("E", 50, 50));
        int capacity = 20;

        int maxHappiness = getMaxHappiness(cakes, capacity);
        System.out.println("Max Happiness:" + maxHappiness);

    }

    private static int getMaxHappiness(ArrayList<Cake> cakes, int capacity) {
        int maxHappiness = 0;
        int currCapacity = 0;
        cakes.sort(new CakeComparator());

        for (Cake cake : cakes) {
            if (currCapacity == capacity) {
                break;
            }

            // Take the full Cake
            if (cake.weight <= capacity - currCapacity) {
                maxHappiness += cake.happiness;
                currCapacity += cake.weight;

            // Take fraction of the cake since the capacity cannot accommodate the full cake
            } else if (cake.weight > capacity - currCapacity ) {
                maxHappiness += (int) ((capacity - currCapacity) * cake.happinessPerUnit);
                currCapacity += (capacity - currCapacity);
            }
        }
        return maxHappiness;
    }


}

class Cake {
    String name;
    int happiness;
    int weight;
    double happinessPerUnit;

    public  Cake(String name, int happiness, int weight) {
        this.name = name;
        this.happiness = happiness;
        this.weight = weight;
        happinessPerUnit = (double) happiness / weight;
    }

    @Override
    public String toString() {
        return "Cake{" +
                "name='" + name + '\'' +
                ", happiness=" + happiness +
                ", weight=" + weight +
                ", happinessPerUnit=" + happinessPerUnit +
                '}';
    }
}

class CakeComparator implements Comparator<Cake> {

    @Override
    public int compare(Cake cake1, Cake cake2) {
        return Double.compare(cake2.happinessPerUnit, cake1.happinessPerUnit);
    }
}
