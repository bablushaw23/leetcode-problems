/*
 * @lc app=leetcode id=237 lang=java
 *
 * [237] Delete Node in a Linked List
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) {
        // I will not get head, so I have no access to previous node so next value of
        // previous node cant be changed
        // Idea is to replace given node, its next and next and so on values to its
        // previous value and next of 2nd last node to null

        ListNode prevNode = node; // save previous node to ensure making next of it null to deallocate last node

        while (node.next != null) { // loop till 2nd last node
            node.val = node.next.val; // assign next node's value
            prevNode = node; // save previous node
            node = node.next; // go to next node
        }
        prevNode.next = null;
    }
}
// @lc code=end
