package revision_oct2025.graphs;

import java.util.Arrays;

public class AdjMat {
    static final char A = 'A';
    public static void main(String[] args) {
        Graph graph = new Graph(3);
        graph.addEdge('A', 'B');
        graph.addEdge('B', 'C');
        graph.addEdge('C', 'A');
        graph.printMat();

    }

    private static class Graph {
        int[][] adjMat;

        Graph(int size) {
            adjMat = new int[size][size];
        }

        void addEdge(char src, char dest) {

            adjMat[src - A][dest - A] = 1;
            adjMat[dest - A][src - A] = 1;
        }

        void printMat() {
            for (int[] row : adjMat) {
                System.out.println(Arrays.toString(row));
            }
        }
    }
}
