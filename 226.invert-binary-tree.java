/*
 * @lc app=leetcode id=226 lang=java
 *
 * [226] Invert Binary Tree
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
    public TreeNode invertTree(TreeNode root) {
        if (root == null)
            return null;
        TreeNode swap = root.left;
        root.left = root.right;
        root.right = swap;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
}
// @lc code=end
