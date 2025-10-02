package dsa_2024_25.graphs;

import linkedlist.Node;

import java.util.*;

/*
 * Given an unweighted graph, find min distance from a source node to all the nodes.
 * e.g.      A -- B -- C         src E :
 *           |    |    |
 *           F -- E -- D
 *                   /
 *            H -- G
 *
 *  Answer:
 *   A:2, B:1, C:2, D:1, E:0, F:1, G:2, H:3
 *
 * */
public class MinDistSrcToAll {
    public static void main(String[] args) {
        Character[][] edges = {{'A', 'B'}, {'A', 'F'}, {'B', 'C'}, {'B', 'E'}, {'F', 'E'}, {'C', 'D'},
                {'E', 'D'}, {'D', 'G'}, {'G', 'H'}};

        Graph graph = new Graph(edges);
        HashMap<Character, Integer> minDist = graph.getMinDistance('E');
        System.out.println(minDist);


    }

    private static class Graph {
        private static HashMap<Character, List<Character>> adjList;

        Graph(Character[][] edges) {
            adjList = new HashMap<>();

            for (int i = 0; i < edges.length; i++) {
                Character src = edges[i][0], dest = edges[i][1];
                addVertex(src);
                addVertex(dest);
                adjList.get(src).add(dest);
                adjList.get(dest).add(src);
            }

        }

        static void addVertex(Character v) {
            adjList.putIfAbsent(v, adjList.getOrDefault(v, new ArrayList<>()));
        }

        HashMap<Character, Integer> getMinDistance(Character source) {

            Queue<NodeDistance> queue = new LinkedList<>();
            queue.add(new NodeDistance(source, 0));
            HashMap<Character, Integer> minDist = new HashMap<>();
            HashSet<Character> visited = new HashSet<>();

            while (!queue.isEmpty()) {
                NodeDistance nodeDistance = queue.poll();
                Character node = nodeDistance.node;
                int distance = nodeDistance.distance;
                visited.add(node);

                // Add/Update min distance
                minDist.putIfAbsent(node, Math.min(distance, minDist.getOrDefault(node, Integer.MAX_VALUE)));

                for (Character neighbour : adjList.get(node)) {
                    if (!visited.contains(neighbour)) {
                        queue.add(new NodeDistance(neighbour, distance + 1));
                    }
                }
            }
            return minDist;
        }

    }

    private static class NodeDistance {
        Character node;
        Integer distance;

        NodeDistance(Character node, Integer distance) {
            this.node = node;
            this.distance = distance;
        }
    }

}
