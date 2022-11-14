import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode id=94 lang=java
 *
 * [94] Binary Tree Inorder Traversal
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

    // Trivial recursive solution, beats 43% TC:O(n) SC:O(n)

    // public List<Integer> inorderTraversal(TreeNode root) {
    // List<Integer> inorder = new ArrayList<>();
    // inorderTraversal(root, inorder);
    // return inorder;
    // }

    // public void inorderTraversal(TreeNode root, List<Integer> traversal) {
    // if (root != null) {
    // inorderTraversal(root.left, traversal);
    // traversal.add(root.val);
    // inorderTraversal(root.right, traversal);
    // }
    // }

    // Iterative way, beats: 43%, TC:O(n) SC:O(n)
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> travel = new ArrayList<>();
        if (root == null)
            return travel;
        Stack<TreeNode> stk = new Stack<>();

        TreeNode current = root;

        do {
            if (current != null) {
                stk.push(current);
                current = current.left;
            } else {
                current = stk.pop();
                travel.add(current.val);
                current = current.right;
            }
        } while (!stk.empty() || current != null);
        return travel;
    }
}
// @lc code=end
