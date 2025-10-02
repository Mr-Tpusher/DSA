package dsa_2024_25.greedy_algos;

import trees.MirrorTrees;

import java.util.ArrayList;

/*
* Given a string representing N seats where some people are already sitting.
* x -> seat is occupied
* . -> seat is empty
* in 1 hop, the person can move to 1 seat left or right.
*
* Find the minimum number of hops required to make all people sit together.
*
* seats = "x....xx..x"
* answer = 6
*
*
* */
public class Seats {
    public static void main(String[] args) {
        //String seats = "x....xx..x";
        //String seats = ".xxx";
        String seats = "....x..xx...x..";
        System.out.println(minHops(seats));
    }

    // The idea is to bring people to the median seat, this way hops will be minimized.
    private static int minHops(String seats) {

        // get the total occupied seats
        int totalOccupiedSeats = 0;
        for (int i = 0; i < seats.length(); i++) {
            if (seats.charAt(i) == 'x') {
                totalOccupiedSeats++;
            }
        }

        // Get the median seat number so that we can gather everyone around it.
        int medianSeatNumber = 0;
        int temp = 0;
        for (int i = 0; i < seats.length(); i++) {
            if (seats.charAt(i) == 'x') {
                temp++;
                if (temp == (totalOccupiedSeats + 1) / 2) {
                    medianSeatNumber = i;
                    break;
                }
            }
        }

        // Create a window around median seat number
        int windowStart = 0;
        if (totalOccupiedSeats % 2 == 0) {
            windowStart = medianSeatNumber - totalOccupiedSeats / 2 + 1;
        } else {
            windowStart = medianSeatNumber - totalOccupiedSeats / 2;
        }

        // calculate the hops required
        int totalHops = 0;
        for (int i = 0; i < seats.length(); i++) {
            if (seats.charAt(i) == 'x') {
                totalHops += Math.abs(windowStart - i);
                windowStart++;
            }
        }
        return totalHops;
    }
}
