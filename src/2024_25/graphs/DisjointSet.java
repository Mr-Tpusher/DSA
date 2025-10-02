package graphs;

import java.util.Arrays;

/*
 * Disjoint sets are the sets which do not have nodes in common.
 * Can be represented by Tree.
 * The root node of the tree can be chosen as the leader/representative of the set.
 * i.e. All the elements can be said to be belonging to the set named leader.
 *
 * */
public class DisjointSet {
    int[] parent;
    int[] rank;

    DisjointSet(int n) {
        parent = new int[n];
        rank = new int[n];

        for (int i = 0; i < n; i++) {
            // Initially each node is its own parent
            parent[i] = i;
            // Initially the rank of each node is zero - Here rank corresponds to height of the tree
            rank[i] = 0;
        }
    }

    // Roots is the leader/representative of the set
    int findRoot(int x) {
        if (x == parent[x]) {
            return x;
        }

        // Path compression
        parent[x] = findRoot(parent[x]);
        return parent[x];
    }

    void union(int u, int v) {
        int rootU = findRoot(u);
        int rootV = findRoot(v);

        // When the vertices belong to the same set(cc), we cannot union them
        if (rootU == rootV) {
            return;
        }

        if (rank[rootU] < rank[rootV]) {
            parent[rootU] = rootV;
        } else if (rank[rootU] > rank[rootV]) {
            parent[rootV] = rootU;
        } else {
            parent[rootU] = rootV;
            rank[rootV]++; // Increment the rank/height of the root since both ranks were same
        }
    }

    boolean isConnected(int u, int v) {
        return findRoot(u) == findRoot(v);
    }

    public static void main(String[] args) {
        DisjointSet ds = new DisjointSet(5);

        ds.union(0,1);
        ds.union(2,3);
        ds.union(3,4);

        System.out.println("Are nodes 0 and 4 connected? " + ds.isConnected(0, 4));
        System.out.println("Are nodes 2 and 4 connected? " + ds.isConnected(2, 4));
    }
}
