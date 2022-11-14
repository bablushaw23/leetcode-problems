/*
 * @lc app=leetcode id=993 lang=java
 *
 * [993] Cousins in Binary Tree
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {

    // beats 100%
    // TC: to search a node, in worst case whole tree has to explore once so n
    // searching done twice so 2n.. Therefore, O(n)
    // SC: during search stack max length is n so O(n)
    public boolean isCousins(TreeNode root, int x, int y) {
        // 1. find parent of x with its level;
        // 2. find parent of y with its level
        // 3. if levels are same and parent are different then return true else false

        // cover edge cases

        TreeNode parentX = new TreeNode(-1);
        TreeNode parentY = new TreeNode(-1);

        int levelX = searchNode(root, parentX, 0, x);
        int levelY = searchNode(root, parentY, 0, y);

        if (levelX == levelY && parentY.val != parentX.val)
            return true;
        return false;

    }

    public int searchNode(TreeNode root, TreeNode parent, int level, int key) {
        if (root == null)
            return -1;

        if (root.val == key)
            return level;
        parent.val = root.val;
        int levelUp = searchNode(root.left, parent, level + 1, key);
        if (levelUp != -1) {
            return levelUp;
        }
        parent.val = root.val;
        return searchNode(root.right, parent, level + 1, key);
    }

}
// @lc code=end
