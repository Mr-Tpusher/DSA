package revision_oct2025.dynamic_programming.knapsack;

import dsa_2024_25.util.Array;

import java.util.Arrays;
import java.util.Comparator;

/*
* You are given N cakes and each cake has some happiness value and weight associated with it.
* Find max happiness value you can get after purchasing w kg cake.
*
* H:  2,3,8,10
* wt: 4,2,3,6
* */
public class fractionalKnapSack {
    public static void main(String[] args) {
        int[] H = {2,3,8,10};
        int[] wt = {4,2,3,6};
        int capacity = 5;

        Cake[] cakes = new Cake[H.length];
        for (int i = 0; i < H.length; i++) {
            cakes[i] = new Cake(H[i], wt[i]);
        }

        System.out.println(Arrays.toString(cakes));

        Arrays.sort(cakes,(cake1, cake2) -> Double.compare(cake2.happinessPerUnitWeight, cake1.happinessPerUnitWeight));

        System.out.println(Arrays.toString(cakes));

        System.out.println(getMaxHappiness(cakes, capacity));

    }

    static double getMaxHappiness(Cake[] cakes, int capacity) {
        double maxHappiness = 0;
        for (Cake cake : cakes) {
            int pickedCakeWeight = 0;
            if (cake.weight >= capacity) {
                pickedCakeWeight = capacity;
            } else {
                pickedCakeWeight = cake.weight;
            }

            maxHappiness += (pickedCakeWeight * cake.happinessPerUnitWeight);
            capacity -= pickedCakeWeight;
        }
        return maxHappiness;
    }

    private static class Cake {
        int happiness;
        int weight;
        double happinessPerUnitWeight;

        Cake(int happiness, int weight) {
            this.happiness = happiness;
            this.weight = weight;
            this.happinessPerUnitWeight = (double) happiness / weight;
        }

        @Override
        public String toString() {
            return "Cake{" +
                    "happiness=" + happiness +
                    ", weight=" + weight +
                    ", happinessPerUnitWeight=" + happinessPerUnitWeight +
                    '}';
        }
    }

}
