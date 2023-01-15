/*
 * @lc app=leetcode id=1293 lang=java
 *
 * [1293] Shortest Path in a Grid with Obstacles Elimination
 */

// @lc code=start
class Solution {

    // public static void main(String[] args) {
    // Solution1293 s = new Solution1293();
    // int[][] grid = new int[][] { { 0, 0, 0 }, { 1, 1, 0 }, { 0, 0, 0 }, { 0, 1, 1
    // }, { 0, 0, 0 } };
    // s.shortestPath(grid, 1);
    // System.out.println(s.smallestWalk);
    // }

    class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public boolean equals(Point that) {
            if (x == that.x && y == that.y)
                return true;
            return false;
        }
    }

    int smallestWalk = 40 * 40 + 1;

    public int shortestPath(int[][] grid, int k) {
        if (grid.length == 1 && grid[0].length == 1)
            return 0;
        Point from = new Point(-1, -1);
        Point now = new Point(0, 0);
        shortestPath(grid, from, now, k, 0);
        if (smallestWalk == 40 * 40 + 1)
            return -1;
        return smallestWalk;
    }

    private void shortestPath(int[][] grid, Point from, Point now, int left_walls, int walked) {
        Point end = new Point(grid[0].length - 1, grid.length - 1);
        // Down
        Point to = new Point(now.x, now.y + 1);
        explore(grid, from, now, left_walls, walked, end, to);

        // Left
        to = new Point(now.x - 1, now.y);
        explore(grid, from, now, left_walls, walked, end, to);

        // Right
        to = new Point(now.x + 1, now.y);
        explore(grid, from, now, left_walls, walked, end, to);

        // Up
        to = new Point(now.x, now.y - 1);
        explore(grid, from, now, left_walls, walked, end, to);
    }

    private void explore(int[][] grid, Point from, Point now, int left_walls, int walked, Point end, Point to) {
        if (!to.equals(from) && isSafe(to, grid)) {
            // is wall
            if (grid[to.y][to.x] != 0) {
                if (left_walls > 0)
                    left_walls--;
                else
                    return;
            }
            walked++;
            if (to.equals(end)) {
                if (walked < smallestWalk)
                    smallestWalk = walked;
                return;
            }
            shortestPath(grid, now, to, left_walls, walked);
        }
    }

    private static boolean isSafe(Point point, int[][] grid) {
        if (point.x < 0 || point.x >= grid[0].length) // out of range
            return false;
        if (point.y < 0 || point.y >= grid.length) // out of range
            return false;
        return true;
    }
}
// @lc code=end
