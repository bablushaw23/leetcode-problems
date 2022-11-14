import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode id=144 lang=java
 *
 * [144] Binary Tree Preorder Traversal
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
    // recursive solution beats 44%
    // public List<Integer> preorderTraversal(TreeNode root) {
    // List<Integer> travel = new ArrayList<>();
    // preorderTraversal(root, travel);
    // return travel;

    // }

    // public void preorderTraversal(TreeNode root, List<Integer> travel) {
    // if (root != null) {
    // travel.add(root.val);
    // preorderTraversal(root.left, travel);
    // preorderTraversal(root.right, travel);
    // }
    // }

    // iterative: beats 100% TC:O(n)
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> travel = new ArrayList<>();
        TreeNode current = root;
        if (current == null)
            return travel;

        Stack<TreeNode> stk = new Stack<>();

        do {
            if (current != null) {
                travel.add(current.val);
                if (current.right != null)
                    stk.push(current.right);
                current = current.left;
            } else {
                current = stk.pop();
            }
        } while (!stk.empty() || current != null);

        return travel;
    }
}
// @lc code=end
