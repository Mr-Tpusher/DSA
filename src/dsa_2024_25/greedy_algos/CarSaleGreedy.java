package dsa_2024_25.greedy_algos;

import java.util.*;

/*
* We walk in a car shop and a sale is going on.
* A[i] -> Time by which the sale ends for an ith car
* B[i] -> Beauty of the ith car
* We need to purchase the cars s.t. the beauty factor is maximized.
*
* Constraints:
* - It takes 1 unit time, to purchase a car
* - You can buy only one car at a time
* - We enter the shop at t=0, we can buy the ith car
*   if t < x where x=sale end time A[i]
*
* A = {3, 1, 3, 2, 3}
* B = {6, 5, 3, 1, 9}
*
*
* */
public class CarSaleGreedy {
    public static void main(String[] args) {
        //int[] A = {3, 1, 3, 2, 3};
        //int[] B = {6, 5, 3, 1, 9};

        int[] A = {1, 3, 3, 3, 5, 5, 5};
        int[] B = {5, 10, 7, 20, 4, 3, 8};

        List<Car> cars = Car.getCars(A, B);

        CarSaleGreedy csg = new CarSaleGreedy();
        int maxBeautyBruteForce = csg.getMaxBeauty(cars);
        System.out.println(maxBeautyBruteForce);

    }

    public int getMaxBeauty(List<Car> cars) {
        cars.sort(new CarsBeautyComparator());
        PriorityQueue<Integer> heap = new PriorityQueue<>();

        int saleEndTime = getSaleEndTime(cars);
        int currTime = 0;

        for (Car car : cars) {
            if (currTime < saleEndTime && currTime < car.saleEndTime) {
                heap.add(car.beauty);
                currTime++;
            } else if (car.beauty > heap.peek()) {
                heap.poll();
                heap.add(car.beauty);
            }
        }

        int maxBeauty = 0;
        while (heap.peek() != null) {
            maxBeauty += heap.poll();
        }

        return maxBeauty;
    }

    public static int getSaleEndTime(List<Car> cars) {
        int saleEndTime = 0;
        for (Car car : cars) {
            if (car.saleEndTime > saleEndTime) {
                saleEndTime = car.saleEndTime;
            }
        }
        return saleEndTime;
    }
}

class CarsBeautyComparator implements Comparator<Car> {

    @Override
    public int compare(Car car1, Car car2) {
        return Integer.compare(car1.saleEndTime, car2.saleEndTime);
    }
}
