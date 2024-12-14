package graphs;

import java.util.*;

/*
* Given connections between users on a platform like LinkedIn, find degree
* of connection between asked users.
*
    A
   / \
  B   C
  |   |
  D   E - F

*
*
* */
public class DegreeOfConnection {
    public static void main(String[] args) {
        Graph graph =  new DegreeOfConnection.Graph();
        graph.addConnection("A", "B");
        graph.addConnection("A", "C");
        graph.addConnection("B", "D");
        graph.addConnection("C", "E");
        graph.addConnection("E", "F");

        System.out.println(graph.degreeOfConnection("A", "C"));
        System.out.println(graph.degreeOfConnection("A", "E"));
        System.out.println(graph.degreeOfConnection("B", "F"));
        System.out.println(graph.degreeOfConnection("F", "F"));
        System.out.println(graph.degreeOfConnection("F", "Z"));

    }


    private static class Graph {
        private final HashMap<String, List<String>> adjList;

        Graph() {
            this.adjList = new HashMap<>();
        }

        void addVertex(String user) {
            adjList.putIfAbsent(user, new ArrayList<>());
        }

        void addConnection(String src, String dest) {
            addVertex(src);
            addVertex(dest);
            adjList.get(src).add(dest);
            adjList.get(dest).add(src);
        }

        int degreeOfConnection(String user1, String user2) {

            if (user1.equals(user2)) {
                return 0;
            }

            // It is a simple bfs
            HashSet<String> visited = new HashSet<>();
            Queue<UserDegree> queue = new LinkedList<>();

            visited.add(user1);
            queue.add(new UserDegree(user1, 0));

            while (!queue.isEmpty()) {
                UserDegree userDegree = queue.poll();

                for (String neighbour : adjList.get(userDegree.user)) {
                    if (!visited.contains(neighbour)) {
                        if (neighbour.equals(user2)) {
                            return userDegree.degree + 1;
                        }
                        visited.add(neighbour);
                        queue.add(new UserDegree(neighbour, userDegree.degree + 1));
                    }
                }
            }
            return -1; // No connection found
        }
    }

    private static class UserDegree {
        String user;
        Integer degree;

        UserDegree(String user, Integer degree) {
            this.user = user;
            this.degree = degree;
        }
    }
}
