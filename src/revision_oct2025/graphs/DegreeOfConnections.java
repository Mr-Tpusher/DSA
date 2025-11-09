package revision_oct2025.graphs;

import java.util.*;

/*
* Given connections between users on a social media app, find degree of connection.
*
*       A
*     / | \
*   B   C   D
*   |      / \
*   E     F   G - H
*
* */
public class DegreeOfConnections {
    public static void main(String[] args) {
        Graph graph = new Graph();

        graph.addConnection("A","B");
        graph.addConnection("A", "C");
        graph.addConnection("A", "D");
        graph.addConnection("B", "E");
        graph.addConnection("D", "F");
        graph.addConnection("D", "G");
        graph.addConnection("G", "H");

        System.out.println("degree of connection between A and B is " + graph.getDegreeOfConnection("A", "B"));
        System.out.println("degree of connection between A and D is " + graph.getDegreeOfConnection("A", "D"));
        System.out.println("degree of connection between A and G is " + graph.getDegreeOfConnection("A", "G"));
        System.out.println("degree of connection between E and H is " + graph.getDegreeOfConnection("E", "H"));
        System.out.println("degree of connection between X and A is " + graph.getDegreeOfConnection("X", "A"));

    }


    private static class Graph {
        private Map<String, Set<String>> adjList = new HashMap<>();

        void addConnection(String first, String  second) {
            adjList.putIfAbsent(first, new HashSet<>());
            adjList.putIfAbsent(second, new HashSet<>());

            adjList.get(first).add(second);
            adjList.get(second).add(first);
        }

        int getDegreeOfConnection(String first, String second) {

            // bfs
            Queue<UserDegree> queue = new LinkedList<>();
            Set<String> visited = new HashSet<>();

            queue.offer(new UserDegree(first, 0));
            visited.add(first);

            while (!queue.isEmpty()) {
                UserDegree currUserDegree = queue.poll();

                if (currUserDegree.user.equals(second)) {
                    return currUserDegree.degree;
                }

                for (String neighbour : adjList.getOrDefault(currUserDegree.user, Collections.emptySet())) {
                    if (!visited.contains(neighbour)) {
                        queue.offer(new UserDegree(neighbour, currUserDegree.degree + 1));
                        visited.add(neighbour);
                    }
                }

            }
            return -1;
        }

        private static class UserDegree {
            String user;
            int degree;
            UserDegree(String user, int degree) {
                this.user = user;
                this.degree = degree;
            }
        }
    }
}
