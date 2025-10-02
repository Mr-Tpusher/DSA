package dsa_2024_25.greedy_algos;

import java.util.ArrayList;
import java.util.List;

class Car {
    int saleEndTime;
    int beauty;

    public Car(int a, int b) {
        this.saleEndTime = a;
        this.beauty = b;
    }

    public static List<Car> getCars(int[] A, int[] B) {
        ArrayList<Car> cars = new ArrayList<>();
        for (int i = 0; i < A.length; i++) {
            cars.add(new Car(A[i], B[i]));
        }
        return cars;
    }

    @Override
    public String toString() {
        return "Car{" +
                "saleEndTime=" + saleEndTime +
                ", beauty=" + beauty +
                '}';
    }
}
