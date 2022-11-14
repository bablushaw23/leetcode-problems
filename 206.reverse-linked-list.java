import javax.management.ListenerNotFoundException;

/*
 * @lc app=leetcode id=206 lang=java
 *
 * [206] Reverse Linked List
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
    public ListNode reverseList(ListNode head) {
        ListNode current = head; // use for tracking

        // loop to end of LL
        ListNode prev = null, next;
        while (current != null) {
            next = current.next; // saving next node before edit or lost
            current.next = prev; // edit next node loc to previous, for reverse
            prev = current; // save previous for next iteration
            current = next; // using saved next location
        }
        return prev; // return, as it points the last node
    }
}
// @lc code=end
