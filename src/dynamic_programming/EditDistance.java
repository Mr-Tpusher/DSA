package dynamic_programming;
/*
* Given two strings, give minimum number of operations required to convert string A to String B.
* Only 3 operations are allowed here:
* 1. Insert a char
* 2. Delete a char
* 3. Replace a char
*
* A: "anshuman"
* B: "antihuman"
*
* */
public class EditDistance {
    public static void main(String[] args) {
        String A = "anshuman";
        String B = "antihuman";
        System.out.println(solve(A, B));

    }

    public static int solve(String A, String B) {
        int[][] dp = new int[A.length() + 1][B.length() + 1];
        return solve(A, B, 0, 0, dp);
    }

    public static int solve(String A, String B, int a, int b, int[][] dp) {
        if (a == A.length() || b == B.length()) {
            // when either of source or destination strings are processed
            // 1. When source is completely processed, we perform add operations
            // 2. When destination is completely processed we perform delete operations
            int ops =  Math.abs(A.length() - a) + Math.abs(B.length() - b);
            dp[a][b] = ops;
            return ops;
        }

        if (dp[a][b] != 0) {
            return dp[a][b];
        }

        if (A.charAt(a) == B.charAt(b)) {
            int ops = solve(A, B, a + 1, b + 1, dp);
            dp[a][b] = ops;
            return ops;
        } else {
            int insertOps = 1 + solve(A, B, a, b + 1, dp);
            int replaceOps = 1 + solve(A, B, a + 1, b + 1, dp);
            int deleteOps = 1 + solve(A, B, a + 1, b, dp);
            int ops = Math.min(Math.min(insertOps, replaceOps), deleteOps);
            dp[a][b] = ops;
            return ops;
        }
    }
}
