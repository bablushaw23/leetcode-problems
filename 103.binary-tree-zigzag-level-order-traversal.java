import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode id=103 lang=java
 *
 * [103] Binary Tree Zigzag Level Order Traversal
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

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList();
        if (root == null)
            return result;
        Queue<TreeNode> bfs = new LinkedList<>();
        bfs.add(root);

        boolean leftToRight = true;
        while (!bfs.isEmpty()) {
            int size = bfs.size();
            Integer[] levelOrder = new Integer[size];
            for (int i = 0; i < size; i++) {
                TreeNode node = bfs.poll();
                levelOrder[leftToRight ? i : (size - 1 - i)] = node.val;
                if (node.left != null)
                    bfs.add(node.left);
                if (node.right != null)
                    bfs.add(node.right);
            }
            leftToRight = !leftToRight;
            result.add(Arrays.asList(levelOrder));
        }
        return result;
    }
}
// @lc code=end
