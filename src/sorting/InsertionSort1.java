package sorting;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InsertionSort1 {
    public static void main(String[] args) {

        List<Integer> numbers = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Enter next element: ");
            String s = scanner.nextLine();
            System.out.println(s);
            if (s.equalsIgnoreCase("n")) {
                break;
            } else {
                int n = Integer.parseInt(s);
                System.out.println("parsed Int:" + n);
                sort(numbers, n);
            }
            System.out.println(numbers);
        }
    }

    public static void sort(List<Integer> numbers, int n) {
        int size = numbers.size();

        if (size == 0) {
            numbers.add(n);
            return;
        }

        int index = searchRightPosition(numbers, n);
        System.out.println("right index for " + n + " : " + index);
        rightShiftAndAdd(numbers, index, n);

    }

    public static void rightShiftAndAdd(List<Integer> numbers, int index, int n) {

        if (numbers.isEmpty()) {
            numbers.add(n);
            return;
        }
        numbers.add(n);
        for (int i = numbers.size() - 2; i >= index; i--) {
            int element = numbers.get(i);
            numbers.set(i + 1, element);
        }
        numbers.set(index, n);
    }

    public static int searchRightPosition(List<Integer> numbers, int n) {
        if (numbers.isEmpty()) {
            return 0;
        }

        int start = 0;
        int end = numbers.size() - 1;

        while (start <= end) {
            int midIndex = start + (end - start) / 2;
            int midNumber = numbers.get(midIndex);

            if (start == end) {
                if (midNumber < n) {
                    return midIndex + 1;
                } else {
                    return midIndex;
                }
            }

            if (midNumber == n) {
                return midIndex;
            } else if (midNumber > n) {
                end = midIndex - 1;
            } else {
                start = midIndex + 1;
            }
        }
        return start;
    }
}

