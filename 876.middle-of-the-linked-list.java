/*
 * @lc app=leetcode id=876 lang=java
 *
 * [876] Middle of the Linked List
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
    public ListNode middleNode(ListNode head) {
        // Use Rabbit & turtle approach
        // Take Rabbit=head, turtle=head
        // iterate till Rabbit!=null
        // for each iteration, Rabbit =rabbit.next.next and turtle=turtle.next
        // when rabbit=null, then turtle at mid

        ListNode rabbit = head, turtle = head; // init the 2 ptrs
        while (rabbit != null && rabbit.next != null) { // run till rabbit reaches the end
            turtle = turtle.next; // turtle takes 1 step at a time
            rabbit = rabbit.next.next; // rabbit always jumps double the turtle, so when turtle at mid then rabbit
        }
        return turtle;
    }
}
// @lc code=end
