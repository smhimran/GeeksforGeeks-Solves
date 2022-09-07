package Rat_In_A_Maze__GeeksforGeeks;//{ Driver Code Starts
// Initial Template for Java

/**
* Problem link: https://practice.geeksforgeeks.org/problems/rat-in-a-maze-problem/1"
*/

import java.util.*;
class Rat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int[][] a = new int[n][n];
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++) a[i][j] = sc.nextInt();

            Solution obj = new Solution();
            ArrayList<String> res = obj.findPath(a, n);
            Collections.sort(res);
            if (res.size() > 0) {
                for (int i = 0; i < res.size(); i++)
                    System.out.print(res.get(i) + " ");
                System.out.println();
            } else {
                System.out.println(-1);
            }
        }
    }
}

// } Driver Code Ends


// User function Template for Java

// m is the given matrix and n is the order of matrix
class Solution {
    static boolean[][] visited = new boolean[10][10];
    public static ArrayList<String> findPath(int[][] m, int n) {
        ArrayList<String> solution = new ArrayList<>();

        solve(m, n, 0, 0, "", solution);

        return solution;
    }

    private static void solve(int[][] matrix, int n, int i, int j, String path, ArrayList<String> solution) {
        if (i >= n || j >= n) {
            return;
        }

        if (i < 0 || j < 0) {
            return;
        }

        if (matrix[i][j] == 0) {
            return;
        }

        if (i == n - 1 && j == n - 1) {
            solution.add(path);
            return;
        }

        if (visited[i][j]) {
            return;
        }

        visited[i][j] = true;

        solve(matrix, n, i - 1, j, path + "U", solution);
        solve(matrix, n, i + 1, j, path + "D", solution);
        solve(matrix, n, i, j - 1, path + "L", solution);
        solve(matrix, n, i, j + 1, path + "R", solution);

        visited[i][j] = false;
    }
}