/*
 * @lc app=leetcode id=160 lang=java
 *
 * [160] Intersection of Two Linked Lists
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) {
 * val = x;
 * next = null;
 * }
 * }
 */

public class Solution {
    // beats: 99% taken from:
    // https://leetcode.com/problems/intersection-of-two-linked-lists/discuss/49785/Java-solution-without-knowing-the-difference-in-len!
    // TC: O(n+n) SC:O(1)
    // public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    // if (headA == null || headB == null)
    // return null;
    // ListNode nodeA = headA, nodeB = headB;
    // while (nodeA != nodeB) {
    // nodeA = nodeA == null ? headB : nodeA.next;
    // nodeB = nodeB == null ? headA : nodeB.next;
    // }
    // return nodeA;
    // }

    // beats: 99% TC:O(2m) where m is len of largest list SC:O(1)
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = length(headA), lenB = length(headB); // get length of each

        // Logic is to take both at same distance before end and start,
        // move 1-by-1 and they both will meet at intersection
        // Ex: lenA=8 lenB=5 then take A's pointer at 8-5=3 so, both A and B are
        // at distance 5 from their end. Say, intersection is at 3
        // So, A & B will move to 4 and then 3 where they will point to same ptr

        ListNode A = headA, B = headB;

        while (lenA < lenB) {
            B = B.next;
            lenB--;
        }
        while (lenB < lenA) {
            A = A.next;
            lenA--;
        }
        while (A != B) { // one time both will point to same, if no intersection then at null, return
                         // null then
            A = A.next;
            B = B.next;
        }
        return A;

    }

    public int length(ListNode head) {
        if (head == null)
            return 0;
        int count = 0;
        while (head != null) {
            count++;
            head = head.next;
        }
        return count;
    }
}
// @lc code=end
