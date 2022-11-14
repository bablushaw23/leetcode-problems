/*
 * @lc app=leetcode id=21 lang=java
 *
 * [21] Merge Two Sorted Lists
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

    // Approach 1

    // TC: O(n) SC: O(n) beat: 65%
    // public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
    // if (list1 == null && list2 == null)
    // return null;
    // ListNode node = new ListNode();
    // ListNode head = node;
    // while (list1 != null && list2 != null) {
    // if (list1.val <= list2.val) {
    // node.val = list1.val;
    // list1 = list1.next;
    // } else {
    // node.val = list2.val;
    // list2 = list2.next;
    // }
    // node.next = new ListNode();
    // node = node.next;
    // }
    // while (list1 != null) {
    // node.val = list1.val;
    // list1 = list1.next;
    // if (list1 != null) {
    // node.next = new ListNode();
    // node = node.next;
    // }
    // }
    // while (list2 != null) {
    // node.val = list2.val;
    // list2 = list2.next;
    // if (list2 != null) {
    // node.next = new ListNode();
    // node = node.next;
    // }
    // }
    // return head;
    // }

    // Approach 2
    // TC: O(m+n) SC; O(1) beats 66%
    // changing next of every node
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        // cover edge case
        if (list1 == null)
            return list2;
        if (list2 == null)
            return list1;

        ListNode head = new ListNode(0); // create a node in which next value will keep 1st node
        ListNode swap; // use for swap
        ListNode saveHead = head; // for return purpose

        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) { // smaller value will be head's next
                swap = list1.next;
                head.next = list1;
                head = head.next;
                list1 = swap;
            } else {
                swap = list2.next;
                head.next = list2;
                head = head.next;
                list2 = swap;
            }
        }
        if (list1 == null) {
            head.next = list2;
        } else
            head.next = list1;
        return saveHead.next;
    }

}
// @lc code=end
