package revision_oct2025.graphs;

import java.util.*;

/*
*           A ----Z
*         / | \  /
*       B   C   D
*      / \  /  / \
*     E    F  G   H
*
* */
public class BFS {
    public static void main(String[] args) {
        UndirectGraph graph = new UndirectGraph();
        graph.addEdge('A', 'B');
        graph.addEdge('A', 'C');
        graph.addEdge('A', 'D');
        graph.addEdge('A', 'Z');
        graph.addEdge('B', 'E');
        graph.addEdge('B', 'F');
        graph.addEdge('C', 'F');
        graph.addEdge('D', 'G');
        graph.addEdge('D', 'H');
        graph.addEdge('D', 'Z');

        graph.printGraph();
        graph.bfs('A');
        graph.bfs('Z');

    }

    private static class UndirectGraph {
        Map<Character, Set<Character>> adjList = new HashMap<>();

        void addEdge(char src, char dest) {
            adjList.putIfAbsent(src, new HashSet<>());
            adjList.putIfAbsent(dest, new HashSet<>());

            adjList.get(src).add(dest);
            adjList.get(dest).add(src);
        }

        void printGraph() {
            System.out.println(adjList);
        }

        void bfs(char src) {
            Queue<Character> queue = new LinkedList<>();
            Set<Character> visited = new HashSet<>();

            queue.add(src);
            visited.add(src);

            while (!queue.isEmpty()) {
                char vertex = queue.poll();
                // Process
                System.out.print(vertex + " ");

                for (char neighbour : adjList.get(vertex)) {
                    if (!visited.contains(neighbour)) {
                        queue.add(neighbour);
                        visited.add(neighbour);
                    }
                }
            }
            System.out.println();
        }
    }
}
