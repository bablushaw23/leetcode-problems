import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=100 lang=java
 *
 * [100] Same Tree
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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        return preOrder(p, q);
    }

    boolean preOrder(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null)
            return root1 == root2; // if 1 is null then check other 1 is null, then same so return true,otherwise
                                   // false
        return (root1.val == root2.val) && preOrder(root1.left, root2.left) // if root's value is same then proceed
                && preOrder(root1.right, root2.right);
    }
}
// @lc code=end
