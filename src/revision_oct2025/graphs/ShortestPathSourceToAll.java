package revision_oct2025.graphs;

import java.util.*;

/*
*   A --- B --- C
*   |     |     |
*   |     |     |
*   F --- E --- D
*              /
*        H -- G
*
* source - E
* */
public class ShortestPathSourceToAll {
    public static void main(String[] args) {
        UndirectedGraph undirectedGraph = new UndirectedGraph();
        undirectedGraph.addEdge('A', 'B');
        undirectedGraph.addEdge('B', 'C');
        undirectedGraph.addEdge('A', 'F');
        undirectedGraph.addEdge('B', 'E');
        undirectedGraph.addEdge('C', 'D');
        undirectedGraph.addEdge('F', 'E');
        undirectedGraph.addEdge('E', 'D');
        undirectedGraph.addEdge('D', 'G');
        undirectedGraph.addEdge('H', 'G');

        System.out.println(undirectedGraph.getMinDistToAll('E'));
    }

    private static class UndirectedGraph {
        HashMap<Character, List<Character>> adjList = new HashMap<>();

        void addEdge(char src, char dest) {
            adjList.putIfAbsent(src, new ArrayList<>());
            adjList.get(src).add(dest);
            adjList.putIfAbsent(dest, new ArrayList<>());
            adjList.get(dest).add(src);
        }

        Map<Character, Integer> getMinDistToAll(char src) {

            Map<Character, Integer> allShortestDistances = new HashMap<>();
            // lets perform one bfs
            Queue<NodeDistance> queue = new LinkedList<>();
            Set<Character> visited = new HashSet<>();

            queue.add(new NodeDistance(src, 0));
            visited.add(src);

            while (!queue.isEmpty()) {
                NodeDistance nodeDistance = queue.poll();
                char node = nodeDistance.node;
                int distance = nodeDistance.distance;
                allShortestDistances.put(node, distance);

                for (char c : adjList.get(node)) {
                    if (!visited.contains(c)) {
                        queue.add(new NodeDistance(c, distance + 1));
                        visited.add(c);
                    }
                }
            }
            return allShortestDistances;
        }

        private static class NodeDistance {
            char node;
            int distance;
            NodeDistance(char node, int distance) {
                this.node = node;
                this.distance = distance;
            }
        }

    }
}
