import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
 * @lc app=leetcode id=145 lang=java
 *
 * [145] Binary Tree Postorder Traversal
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
    // Recursive soln beats 100%
    // public List<Integer> postorderTraversal(TreeNode root) {
    // List<Integer> travel = new ArrayList<>();
    // if (root == null)
    // return travel;
    // postorderTraversal(travel, root);
    // return travel;
    // }

    // public void postorderTraversal(List<Integer> travel, TreeNode root) {
    // if (root != null) {
    // postorderTraversal(travel, root.left);
    // postorderTraversal(travel, root.right);
    // travel.add(root.val);
    // }
    // }

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> travel = new ArrayList<>();
        TreeNode current = head;
        Stack<Integer> stk = new Stack<>();
        if (current == null)
            return travel;

        do {
            if (current != null) {
                stk.push(current);
                if (current.right != null)
                    stk.push(current.right);
                current = current.left;
            } else {
                current = stk.pop();
                travel.add(current.val);
                current = current.right;
            }
        } while (!stk.empty() || current != null);
    }
}
// @lc code=end
