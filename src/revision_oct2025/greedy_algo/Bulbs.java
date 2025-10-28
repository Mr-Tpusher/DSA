package revision_oct2025.greedy_algo;
/*
* Given initial state of the N bulbs connected with a wire. 0 -> Off , 1 -> ON
* But the wiring is faulty.
* Each bulb has a switch associated with it, given by array S.
* If you press the ith switch, the parity of ith bulb and all the bulbs after it will flip.
*
* Find the min number of switches, that should be pressed to turn on all the bulbs.
*
* B = {0, 1, 0, 0, 1}
* */

public class Bulbs {
    public static void main(String[] args) {
        int[] bulbs = {0, 1, 0, 0, 1};
        System.out.println(switches(bulbs));

    }

    private static int switches(int[] bulbs) {
        int pressedSwitches = 0;
        for (int i = 0; i < bulbs.length; i++) {
            int effectiveState = (pressedSwitches & 1) == 0 ? bulbs[i] : bulbs[i] == 1 ? 0 : 1;
            if (effectiveState == 0)
                pressedSwitches++;
        }
        return pressedSwitches;
    }
}
