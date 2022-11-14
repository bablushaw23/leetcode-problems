import java.util.ArrayList;
import java.util.List;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;

/*
 * @lc app=leetcode id=199 lang=java
 *
 * [199] Binary Tree Right Side View
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

    // beats: 92%
    // TC: O(n) as it will travers through each node
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>(); // will store result in it

        // cover edge case
        if (root == null)
            return result;

        findView(result, root, 0); // 0: for level track, this will ensure a value from a level is already selected
        return result;
    }

    public void findView(List<Integer> result, TreeNode root, int currentLevel) {
        if (root == null) // return if root is null
            return;
        // we have to select only 1 value from a level no more no less and result size
        // will tell how many levels are explored
        // if current level is yet not selected in result then take the 1st value
        // appeared
        if (currentLevel >= result.size())
            result.add(root.val);
        // calling right makes 1st value will always be right of the tree
        findView(result, root.right, currentLevel + 1);
        // left is called for case where right of last node of level_k is null but left
        // has value of k+1 then next level's last value will come from this left node
        findView(result, root.left, currentLevel + 1);
    }
}

// custom cases: [3,9,20,4,7,null,7,9,8,6,5,null,null]
// @lc code=end
