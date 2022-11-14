/*
 * @lc app=leetcode id=543 lang=java
 *
 * [543] Diameter of Binary Tree
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
    public int diameterOfBinaryTree(TreeNode root) {
        findHeight(root);
        return diameter;
    }

    int diameter = 0;

    private int findHeight(TreeNode root) {
        if (root == null)
            return 0;
        int leftHt = findHeight(root.left);
        int rightHt = findHeight(root.right);
        if (leftHt + rightHt > diameter)
            diameter = leftHt + rightHt;
        return Math.max(leftHt, rightHt) + 1;
    }
}
// @lc code=end
