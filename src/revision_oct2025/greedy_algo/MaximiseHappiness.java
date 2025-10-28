package revision_oct2025.greedy_algo;

import java.util.Arrays;

/*
* Given weight of cakes and their happiness value, choose cakes of weight w such that the happiness is maximised.
* We can break the cake into pieces.
* */
public class MaximiseHappiness {
    public static void main(String[] args) {
        int[] weights = {10, 20, 5, 7, 50};
        int[] happiness = {70, 40, 25, 49, 50};
        int weight = 20;

        System.out.println(maxHappiness(weights, happiness, weight));


    }

    /*
    * The idea here is to find the happiness per unit weight and keep choosing the cakes having max value till
    * total weight is w.
    *
    * */

    static double maxHappiness(int[] weights, int[] happiness, int weight) {
        Cake[] cakes = new Cake[weights.length];
        for (int i = 0; i < weights.length; i++) {
            cakes[i] = new Cake(weights[i], happiness[i]);
        }

        Arrays.sort(cakes);

        double maxHappiness = 0;
        for (Cake cake : cakes) {
            if (weight == 0) break;

            if (cake.weight <= weight) {
                maxHappiness += (cake.weight * cake.happinessPerUnitWeight);
                weight -= cake.weight;
            } else {
                maxHappiness += (weight * cake.happinessPerUnitWeight);
                weight -= weight;
            }

        }

        return maxHappiness;
    }

    private static class Cake implements Comparable<Cake> {
        int weight;
        int happiness;
        double happinessPerUnitWeight;

        Cake(int weight, int happiness) {
            this.weight = weight;
            this.happiness = happiness;
            this.happinessPerUnitWeight = (double) happiness / weight;
        }

        @Override
        public int compareTo(Cake cake) {
            return -Double.compare(this.happinessPerUnitWeight, cake.happinessPerUnitWeight);
        }

    }

}
