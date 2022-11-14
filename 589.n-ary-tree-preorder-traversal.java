import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import javax.xml.soap.Node;

/*
 * @lc app=leetcode id=589 lang=java
 *
 * [589] N-ary Tree Preorder Traversal
 */

// @lc code=start

// Definition for a Node.
// class Node {
//     public int val;
//     public List<Node> children;

//     public Node() {
//     }

//     public Node(int _val) {
//         val = _val;
//     }

//     public Node(int _val, List<Node> _children) {
//         val = _val;
//         children = _children;
//     }
// };

class Solution {

    /*
     * Iterative solution: too slow beats 5.83%
     * 
     * public List<Integer> preorder(Node root) {
     * List<Integer> result = new ArrayList<>();
     * if (root == null)
     * return result;
     * 
     * Stack<Node> stk = new Stack<>();
     * Stack<Node> temp = new Stack<>(); // Using this stack to shift elements right
     * to left
     * stk.push(root);
     * while (!stk.isEmpty()) {
     * Node current = stk.pop();
     * result.add(current.val);
     * for (Node child : current.children) {
     * temp.push(child); // push into stack from left to right.. if use same stack
     * the right elem will
     * // pop 1st but I want left one 1st
     * }
     * while (!temp.isEmpty()) { // pop and push to reverse elems
     * stk.push(temp.pop());
     * }
     * }
     * return result;
     * }
     * }
     */

    /*
     * Recursive soln: beats 62%
     * public List<Integer> result = new ArrayList<>();
     * 
     * public List<Integer> preorder(Node root) {
     * if (root == null)
     * return result;
     * result.add(root.val);
     * for (Node child : root.children) {
     * preorder(child);
     * }
     * return result;
     * }
     * 
     */
}
// @lc code=end
