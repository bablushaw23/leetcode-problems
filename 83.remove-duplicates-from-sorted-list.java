/*
 * @lc app=leetcode id=83 lang=java
 *
 * [83] Remove Duplicates from Sorted List
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    // TC: O(n) SC: O(1) beats: 65%
    public ListNode deleteDuplicates(ListNode head) {
        // cover edge case
        if (head == null)
            return head;

        ListNode prevNode = head; // keep previous node to overwrite its next
        ListNode current = head.next; // node for traversal

        // loop till end of the list
        while (current != null) {
            // if two values matched then next of 1st node will be next of 2nd, this way
            // intensionally losing ref of node to be deleted
            if (current.val == prevNode.val) {
                prevNode.next = current.next;
            } else {
                prevNode = current;
            }
            current = current.next;
        }
        return head;
    }
}
// @lc code=end
