package dsa_2024_25.greedy_algos;

public class SeatArrangement {
    public static void main(String[] args) {
        String A = "....x..xx...x..";
        System.out.println(seats(A));
    }
    private static int seats(String A) {
        int MOD = 10000003;

        int totalOccupiedSeats = 0;
        for (int i = 0; i < A.length(); i++) {
            if (A.charAt(i) == 'x')
                totalOccupiedSeats++;
        }

        int medianSeat = totalOccupiedSeats / 2 + 1;
        int medianIndex = 0;
        for (int i = 0; i < A.length(); i++) {
            if (A.charAt(i) == 'x')
                medianSeat--;

            if (medianSeat == 0) {
                medianIndex = i;
                break;
            }
        }

        int ans = 0;
        int leftNeighbour = medianIndex - 1;
        for (int i = 0; i < medianIndex; i++) {
            if (A.charAt(i) == 'x') {
                ans = ((ans % MOD) + (leftNeighbour - i) % MOD) % MOD;
                leftNeighbour--;
            }
        }

        int rightNeighbour = medianIndex + 1;
        for (int i = medianIndex + 1; i < A.length(); i++) {
            if (A.charAt(i) == 'x') {
                ans = ((ans % MOD) + (i - rightNeighbour) % MOD) % MOD;
                rightNeighbour++;
            }
        }
        return ans;
    }
}
