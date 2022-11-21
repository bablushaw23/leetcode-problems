package recursion;

//{ Driver Code Starts
import java.util.*;

class MColouring {
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
        int[] color = new int[n];
        boolean r = ifColor(color, graph, m, n, 0);
        return r;
    }

    public boolean ifColor(int[] colorSel, boolean graph[][], int m, int n, int v) {
        if (v == n) // base case
            return true;
        int color;
        changeClr: for (color = 1; color <= m; color++) { // choose all clrs serially
            for (int clm = 0; clm < n; clm++) { // look into each clm if that clr is used
                if (clm != v && graph[v][clm] && color == colorSel[clm]) // if that clm is adjacent and have the same
                                                                         // clr
                    continue changeClr; // go, take new clr
            } // looked into all clms and no same clr found
            colorSel[v] = color; // assign it the clr and
            if (ifColor(colorSel, graph, m, n, v + 1)) // go for next vertex
                return true; // if vertex returns true means next vertex accepted some clr
            colorSel[v] = 0; // u need to reset it to uncolored so that in worst case returned with no color
                             // then
            // its parent can choose the color it selected in ln52
        }
        return false; // when no more colors left to select then return false
    }
}