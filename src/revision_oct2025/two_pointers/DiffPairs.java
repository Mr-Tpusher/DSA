package revision_oct2025.two_pointers;

import java.util.HashSet;
import java.util.Objects;

/*
* Given an one-dimensional integer array A of size N and an integer B.
  Count all distinct pairs with difference equal to B.
  Here a pair is defined as an integer pair (x, y),
  where x and y are both numbers in the array and their absolute difference is B.
*
* */
public class DiffPairs {
    public static void main(String[] args) {
        int[] arr = {1, 5, 4, 3, 2, 4, 2, 5};
        int k = 3;
        System.out.println(solve1(arr, k));
    }

    static int solve1(int[] arr, int B) {
        int count = 0;
        HashSet<Pair> pairs = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                int diff = arr[i] - arr[j];
                Pair p = new Pair(arr[i], arr[j]);
                if (Math.abs(diff) == B && !pairs.contains(p)) {
                    pairs.add(p);
                    count++;
                }
            }
        }
        System.out.println(pairs);
        return count;
    }

    static class Pair {
        int first;
        int second;

        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }

        @Override
        public boolean equals(Object obj) {
            Pair p = (Pair) obj;
            if (((this.first == p.first) && (this.second == p.second))
                    || ((this.first == p.second) && (this.second == p.first))) {
                return true;
            }
            return false;
        }

        @Override
        public int hashCode() {
            return Objects.hash(first, second);
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "first=" + first +
                    ", second=" + second +
                    '}';
        }
    }
}
