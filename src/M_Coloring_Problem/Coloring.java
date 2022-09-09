package M_Coloring_Problem;

//{ Driver Code Starts
import java.util.*;
import java.lang.*;

class Coloring {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int tc = scan.nextInt();

        while (tc-- > 0) {
            int N = scan.nextInt();
            int M = scan.nextInt();
            int E = scan.nextInt();

            boolean graph[][] = new boolean[N][N];

            for (int i = 0; i < E; i++) {
                int u = scan.nextInt() - 1;
                int v = scan.nextInt() - 1;
                graph[u][v] = true;
                graph[v][u] = true;
            }

            System.out.println(new solve().graphColoring(graph, M, N) ? 1 : 0);
        }
    }
}

// } Driver Code Ends


class solve {
    // Function to determine if graph can be coloured with at most M colours
    // such
    // that no two adjacent vertices of graph are coloured with same colour.
    public boolean graphColoring(boolean graph[][], int m, int n) {
        boolean[] visited = new boolean[n + 1];
        int[] colorOnNode = new int[n + 1];

        visited[0] = true;

        return isColoringPossible(graph, m, n, 0, colorOnNode);
    }

    private boolean isColoringPossible(boolean graph[][], int m, int n, int currentNode, int colorOnNode[]) {
        if (currentNode == n) {
            return true;
        }

        for (int color = 1; color <= m; color++) {
            boolean validColor = true;
            for (int i = 0; i < n; i++) {
                if (graph[currentNode][i] && colorOnNode[i] == color) {
                    validColor = false;
                }
            }

            if (validColor) {
                colorOnNode[currentNode] = color;
                boolean ok = isColoringPossible(graph, m, n, currentNode + 1, colorOnNode);
                if (ok) {
                    return true;
                }
                colorOnNode[currentNode] = 0;
            }
        }
        return false;
    }
}