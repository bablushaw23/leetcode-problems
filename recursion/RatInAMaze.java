package recursion;

import java.util.ArrayList;

// problem: https://practice.geeksforgeeks.org/problems/rat-in-a-maze-problem/1
public class RatInAMaze {
    public static void main(String[] args) {
        int[][] m = new int[][] { { 1, 0, 0, 0 },
                { 1, 1, 0, 1 },
                { 1, 1, 0, 0 },
                { 0, 1, 1, 1 } };

        System.out.println(findPath(m, 4));
    }

    public static ArrayList<String> findPath(int[][] m, int n) {
        boolean[][] traversed = new boolean[n][n];
        ArrayList<String> result = new ArrayList<>();
        if (m[0][0] == 0)
            return result;
        traverse(m, result, "", traversed, 0, 0, n);
        return result;
    }

    static void traverse(int[][] maze, ArrayList<String> result, String path, boolean[][] traversed, int x, int y,
            int n) {
        if (x == n - 1 && y == n - 1) {
            result.add(path);
            return;
        }
        String cPath;
        // try-up
        if (safe(x - 1, y, traversed, maze, n)) {
            traversed[x][y] = true;
            cPath = path;
            path += "U";
            traverse(maze, result, path, traversed, x - 1, y, n);
            path = cPath;
            traversed[x][y] = false;
        }

        // try-down
        if (safe(x + 1, y, traversed, maze, n)) {
            traversed[x][y] = true;
            cPath = path;
            path += "D";
            traverse(maze, result, path, traversed, x + 1, y, n);
            path = cPath;
            traversed[x][y] = false;
        }

        // try-left
        if (safe(x, y - 1, traversed, maze, n)) {
            traversed[x][y] = true;
            cPath = path;
            path += "L";
            traverse(maze, result, path, traversed, x, y - 1, n);
            path = cPath;
            traversed[x][y] = false;
        }

        // try-right
        if (safe(x, y + 1, traversed, maze, n)) {
            traversed[x][y] = true;
            cPath = path;
            path += "R";
            traverse(maze, result, path, traversed, x, y + 1, n);
            path = cPath;
            traversed[x][y] = false;
        }
    }

    private static boolean safe(int x, int y, boolean[][] traversed, int[][] maze, int n) {
        if (x < 0 || x >= n || y < 0 || y >= n || maze[x][y] == 0 || traversed[x][y])
            return false;
        return true;
    }
}