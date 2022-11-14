import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode id=1008 lang=java
 *
 * [1008] Construct Binary Search Tree from Preorder Traversal
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
    // my soln: beats 53% O(nlogn)
    // public TreeNode bstFromPreorder(int[] preorder) {
    // TreeNode root = new TreeNode(preorder[0]);
    // TreeNode current, parent;
    // boolean isLeft = false;

    // for (int i = 1; i < preorder.length; i++) {
    // current = root;
    // parent = root;
    // while (current != null) {
    // parent = current;
    // if (current.val < preorder[i]) {
    // current = current.right;
    // isLeft = false;
    // } else {
    // current = current.left;
    // isLeft = true;
    // }
    // }
    // if (isLeft)
    // parent.left = new TreeNode(preorder[i]);
    // else
    // parent.right = new TreeNode(preorder[i]);
    // }
    // return root;
    // }

    // beats 100% TC: O(n)
    // solution taken from:
    // https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal/discuss/252232/JavaC%2B%2BPython-O(N)-Solution
    public TreeNode bstFromPreorder(int[] preorder) {
        return bstPreOrder(preorder, Integer.MAX_VALUE);
    }

    int i;

    public TreeNode bstPreOrder(int A[], int bound) {
        if (i == A.length || A[i] > bound)
            return null;
        TreeNode root = new TreeNode(A[i++]);
        root.left = bstPreOrder(A, root.val);
        root.right = bstPreOrder(A, bound);
        return root;
    }
}
// @lc code=end
