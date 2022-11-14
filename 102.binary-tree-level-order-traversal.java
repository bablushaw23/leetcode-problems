import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode id=102 lang=java
 *
 * [102] Binary Tree Level Order Traversal
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

    // A POJO to have node with level
    class NodeLevel {
        TreeNode node;
        Integer level;

        public NodeLevel(TreeNode node, Integer level) {
            this.level = level;
            this.node = node;
        }
    }

    // own soln: beats 86%
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<NodeLevel> q = new LinkedList<>(); // need Q for level order mantain
        q.add(new NodeLevel(root, 0)); // 0 shows 1st level
        NodeLevel nodeLevel;
        List<List<Integer>> result = new ArrayList<>(); // to store result
        List<Integer> level = new ArrayList<>(); // each list in result
        int currentLevel = 0; // track of current level

        // run until q is empty
        while (!q.isEmpty()) {
            nodeLevel = q.poll(); // dequeue item, note this item knows its level

            // if new level is appeared then store current level's value into result and
            // ready to store new level
            if (nodeLevel.level != currentLevel) {
                result.add(level); // dumping current level's value
                level = new ArrayList<>(); // creating list to store new level's value
                currentLevel = nodeLevel.level; // updating current level
            }

            // if node is null then its left, right, val will throw null ptr
            if (nodeLevel.node != null) {
                // store the node val
                level.add(nodeLevel.node.val);

                // level of left or right of a node is 1+ of parent node's level
                q.add(new NodeLevel(nodeLevel.node.left, nodeLevel.level + 1));
                q.add(new NodeLevel(nodeLevel.node.right, nodeLevel.level + 1));
            }
        }
        return result;
    }
}

// cases: [1,2,null,3,null,4,null,5]
// @lc code=end
