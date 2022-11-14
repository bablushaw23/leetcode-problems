/*
 * @lc app=leetcode id=142 lang=java
 *
 * [142] Linked List Cycle II
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) {
 * val = x;
 * next = null;
 * }
 * }
 */
public class Solution {
    // beats: 17% TC: O(n2) SC: O(1)
    // public ListNode detectCycle(ListNode head) {
    // int travelled = 0;
    // ListNode current = head, repeat;
    // while (current != null) {
    // current = current.next;
    // travelled++;
    // repeat = head;
    // for (int i = 0; i < travelled; i++) {
    // if (current == repeat)
    // return repeat;
    // repeat = repeat.next;
    // }
    // }
    // return null;
    // }

    // solution taken from
    // https://leetcode.com/problems/linked-list-cycle-ii/discuss/1701055/JavaC%2B%2BPython-best-explanation-ever-happen's-for-this-problem
    // beats: 100% tc: O(n) sc:O(1)
    public ListNode detectCycle(ListNode head) {
        ListNode rabbit = head, turtle = head;

        do {
            if (rabbit == null || rabbit.next == null)
                return null;
            rabbit = rabbit.next.next;
            turtle = turtle.next;
        } while (rabbit != turtle);
        // if reaches here means, cycle exists
        // this way of searching cycle is floyd cycle detection algo

        rabbit = head; // take rabbit to start and move 1x speed

        while (rabbit != turtle) {
            rabbit = rabbit.next;
            turtle = turtle.next;
        }
        return rabbit;
    }
}
// @lc code=end
