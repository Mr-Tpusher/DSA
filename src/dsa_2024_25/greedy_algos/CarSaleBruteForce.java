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
public class CarSaleBruteForce {
    public static void main(String[] args) {
        int[] A = {3, 1, 3, 2, 3};
        int[] B = {6, 5, 3, 1, 9};
        List<Car> cars = Car.getCars(A, B);

        int maxBeautyBruteForce = bruteForce(cars);
        System.out.println(maxBeautyBruteForce);

    }

    public static int bruteForce(List<Car> cars) {
        int saleEndTime = getSaleEndTime(cars);
        ArrayList<Integer> beauties = new ArrayList<>();
        bfGetMaxBeauty(cars, 0, saleEndTime, beauties, 0);

        int maxBeauty = 0;
        for (Integer beaut : beauties) {
            maxBeauty = Math.max(maxBeauty, beaut);
        }
        return maxBeauty;
    }

    public static void bfGetMaxBeauty(List<Car> cars, int currTime, int saleEndTime,
                                      ArrayList<Integer> beauties, int beauty) {
        if (currTime >= saleEndTime || cars.isEmpty()) {
            beauties.add(beauty);
            return;
        }

        ArrayList<Car> options = getOptions(cars, currTime);

        for (int i = 0; i < options.size(); i++) {
            Car currCar = options.get(i);

            ArrayList<Car> remainingCars = new ArrayList<>(cars);
            remainingCars.remove(currCar);

            bfGetMaxBeauty(remainingCars, currTime + 1, saleEndTime, beauties, beauty + currCar.beauty);
        }
    }


    public static ArrayList<Car> getOptions(List<Car> cars, int currTime) {
        Iterator<Car> iterator = cars.iterator();
        ArrayList<Car> options = new ArrayList<>();
        while (iterator.hasNext()) {
            Car currCar = iterator.next();
            if (currCar.saleEndTime > currTime) {
                options.add(currCar);
            }
        }
        return options;
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