import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode id=110 lang=java
 *
 * [110] Balanced Binary Tree
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

// beats 99.25% TC: O(N)
class Solution {
    public boolean isBalanced(TreeNode root) {
        if (root == null)
            return true;
        int leftHt = findHeight(root.left);
        int rightHt = findHeight(root.right);

        // if any value is -1, then its a flag that somewhere in sub-tree it is
        // unbalanced
        if (leftHt == -1 || rightHt == -1)
            return false;

        // check if sub-tree is balanced but on the root it is unbalanced
        if (Math.abs(leftHt - rightHt) > 1)
            return false;

        return true;
    }

    public int findHeight(TreeNode root) {
        if (root == null)
            return 0;
        int leftHt = findHeight(root.left);
        int rightHt = findHeight(root.right);

        // if any value is -1, then its a flag that somewhere in sub-tree it is
        // unbalanced, so just return -1
        // or
        // if this node is unbalanced so return -1
        if ((leftHt == -1 || rightHt == -1) || (Math.abs(leftHt - rightHt) > 1))
            return -1;
        else
            return Math.max(leftHt, rightHt) + 1; // return actual ht.
    }
}
// @lc code=end