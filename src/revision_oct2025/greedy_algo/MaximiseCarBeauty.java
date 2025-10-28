package revision_oct2025.greedy_algo;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/*
 * We walk in a car shop and a sale is going on.
 * A[i] -> the time by which the sale ends for the ith car
 * B[i] -> Beauty of the ith car
 * We need to purchase the cars such that we maximise the beauty factor.
 *
 * Constraints:
 * -> It takes 1 unit time to purchase a car
 * -> Only one car can be bought at any time
 * -> We enter the shop at t = 0
 * -> We can buy the ith car iff t < x where x = A[i] i.e. Sale end time
 *
 * A = {3, 1, 3, 2, 3}
 * B = {6, 5, 3, 1, 9}
 * ans: max beauty = 20
 *
 * */
public class MaximiseCarBeauty {
    public static void main(String[] args) {
        int[] A = {3, 1, 3, 2, 3};
        int[] B = {6, 5, 3, 1, 9};

        CarSale[] cars = new CarSale[A.length];
        for (int i = 0; i < A.length; i++) {
            cars[i] = new CarSale(A[i], B[i]);
        }

        //Arrays.sort(cars, (a, b) -> Integer.compare(b.saleEndTime,a.saleEndTime));
        Arrays.sort(
                cars,
                Comparator
                .comparingInt((CarSale o) -> o.saleEndTime)
                .thenComparing(Comparator.comparingInt((CarSale o) -> o.beauty).reversed()));
        System.out.println(Arrays.toString(cars));

        int maxBeauty = getMaxBeauty(cars);
        System.out.println(maxBeauty);

    }

    private static int getMaxBeauty(CarSale[] cars) {
        PriorityQueue<CarSale> heap = new PriorityQueue<>(Comparator.comparingInt((CarSale o) -> o.beauty));
        int currTime = 0;
        int maxBeauty = 0;

        for (CarSale car : cars) {
            if (car.saleEndTime > currTime) {
                heap.offer(car);
                maxBeauty += car.beauty;
                currTime++;
            } else {
                if (car.beauty > heap.peek().beauty) {
                    maxBeauty -= heap.peek().beauty;
                    heap.poll();
                    maxBeauty += car.beauty;
                    heap.offer(car);
                }
            }
        }
        return maxBeauty;
    }

    private static class CarSale {
        int saleEndTime;
        int beauty;

        CarSale(int saleEndTime, int beauty) {
            this.saleEndTime = saleEndTime;
            this.beauty = beauty;
        }

        @Override
        public String toString() {
            return "CarSale{" +
                    "saleEndTime=" + saleEndTime +
                    ", beauty=" + beauty +
                    '}';
        }
    }
}
