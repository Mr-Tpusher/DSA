package dsa_2024_25.greedy_algos;

import java.util.Arrays;

/*
* There are N bulbs connected with a wire. We've been given initial state of the bulb
* i.e. 0->off or 1->on, the catch is the wiring is faulty.
*
* Every bulb has a switch associated with it. If you press the ith switch, the parity of
* ith bulb and all the bulbs after it (bulbs >= i) switches.
*
* Find the minimum number of switches that should be pressed to turn on all the bulbs.
*
* B = {0, 1, 0, 0, 1}
*
*
*
* */
public class BulbSwitch {
    public static void main(String[] args) {
        int[] bulbs = {0, 1, 0, 0, 1};
        System.out.println(getPressedSwitches(bulbs));
        System.out.println(bruteForce(bulbs));
    }

    public static int getPressedSwitches(int[] bulbs) {
        int switchesPressed = 0;
        for (int i = 0; i < bulbs.length; i++) {
            if (((bulbs[i] == 1) && (switchesPressed % 2 == 1)) ||
                    ((bulbs[i] == 0) && (switchesPressed % 2 == 0))) {
                switchesPressed++;
            }
        }
        return switchesPressed;
    }

    public static int bruteForce(int[] bulbs) {
        int switchesPressed = 0;
        for (int i = 0; i < bulbs.length; i++) {
            System.out.print("checking bulb[" + i + "] : ");
            System.out.println(Arrays.toString(bulbs));
            if (bulbs[i] == 0) {
                switchesPressed++;
                changeParity(bulbs, i);
                System.out.print("Switch pressed[" + i + "] : ");
                System.out.println(Arrays.toString(bulbs));
            }
        }
        return switchesPressed;
    }

    private static void changeParity(int[] bulbs, int i) {
        for (int j = i; j < bulbs.length; j++) {
            bulbs[j] = (bulbs[j] == 0 ? 1 : 0);
        }
    }
}
