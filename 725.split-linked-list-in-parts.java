/*
 * @lc app=leetcode id=725 lang=java
 *
 * [725] Split Linked List in Parts
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

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class Solution {
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode[] headList = new ListNode[k];
        int length = getListLength(head);
        int default_size = length / k;
        int extra = length % k;

        for (int eachHead = 0; eachHead < k; eachHead++) {
            ListNode newHead = head;
            head = head.next;
            headList[eachHead] = newHead;
            for (int item = 2; item < default_size; item++) {
                newHead = newHead.next;

            }
        }

        return nodes;
    }

    public int getListLength(ListNode head) {
        int length = 0;
        ListNode temp = head;
        while (temp != null) {
            length++;
            temp = temp.next;
        }
        return length;
    }
}
// @lc code=end
