package revision_oct2025.sorting;

import java.util.ArrayList;
import java.util.Scanner;

public class InsertionSortGame {
    private static final Scanner scanner = new Scanner(System.in);
    ArrayList<Integer> numbers = new ArrayList<>();

    public static void main(String[] args) {
        InsertionSortGame game = new InsertionSortGame();
        game.start();

    }

    public void start() {

        while (true) {
            System.out.println("Enter a number : ");
            String s = scanner.nextLine();
            try {
                int i = Integer.parseInt(s);
                consumeNumber(i);

                System.out.println(i);
            } catch (Exception e) {
                System.out.println("See you soon!");
                break;
            }
        }
    }

    void consumeNumber(int number) {

        // insertion sort
        if (numbers.isEmpty()) {
            numbers.add(number);
        } else {
            int index = numbers.size() - 1;
            while (index >= 0 && numbers.get(index) > number) {
                numbers.add(index + 1, numbers.get(index));
                index--;
            }
            if (index == numbers.size() - 1) {
                numbers.add(number);
            } else {
                numbers.set(index + 1, number);
            }
        }
        System.out.println(numbers);
    }
}
