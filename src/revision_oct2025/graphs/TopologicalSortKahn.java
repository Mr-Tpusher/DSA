package revision_oct2025.graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
* Topological sort :-
*       It comes into picture for Directed Acyclic Graphs.
*       It is linear ordering of the nodes where if there's an edge going from i to j then i comes before j.
*
* Kahn's algo:
*       It uses concept of indegree and bfs.
*       Indegree of a node is total number of edges coming to that node.
*
*       1 --* 2
*      *|
*     / |
*   0   |
*     \ |
*      **
*       3 --* 4
* */
public class TopologicalSortKahn {

    public static void main(String[] args) {
        DirectedAcyclicGraph dag = new DirectedAcyclicGraph(5);
        dag.addEdge(0, 1);
        dag.addEdge(1, 2);
        dag.addEdge(2, 3);
        dag.addEdge(3, 4);

        System.out.println(dag.topoSort());
    }

    private static class DirectedAcyclicGraph {
        List<List<Integer>> adjList;
        int vertices;

        DirectedAcyclicGraph(int n) {
            this.vertices = n;
            adjList = new ArrayList<>();

            for (int i = 0; i < vertices; i++) {
                adjList.add(new ArrayList<>());
            }
        }

        void addEdge(int u, int v) {
            adjList.get(u).add(v);
        }

        ArrayList<Integer> topoSort() {
            // 1. find Indegree of all the nodes
            int[] inDegree = new int[vertices];
            for (int i = 0; i < vertices; i++) {
                for (int neighbour : adjList.get(i)) {
                    ++inDegree[neighbour];
                }
            }

            // 2. add all the nodes having Indegree 0 into the queue
            Queue<Integer> queue = new LinkedList<>();
            for (int i = 0; i < inDegree.length; i++) {
                if (inDegree[i] == 0)
                    queue.offer(i);
            }

            // 3. start multi-source bfs
            //      poll from the queue, add in the sorted list, reduce indegree of neighbours,
            //      if indegree of any neighbour is 0 then enqueue it
            ArrayList<Integer> topoSort = new ArrayList<>();
            while (!queue.isEmpty()) {
                int node = queue.poll();
                topoSort.add(node);

                for (int neighbour : adjList.get(node)) {
                    --inDegree[neighbour];

                    if (inDegree[neighbour] == 0)
                        queue.offer(neighbour);
                }
            }

            // 4. if the size of sorted list is not equal to the number of vertices then there was a cycle in the graph
            if (topoSort.size() != vertices) {
                System.out.println("Cycle is present in the graph, topological sort is not possible.");
            }

            return topoSort;
        }
    }
}
