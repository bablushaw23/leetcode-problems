/*
 * @lc app=leetcode id=25 lang=java
 *
 * [25] Reverse Nodes in k-Group
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
    public ListNode reverseKGroup(ListNode head, int k) {
        if(k==1)
            return head;    
    ListNode currentNode=head, startNode=head, temp;

    int current=1;

    while(currentNode!=null){
        currentNode=currentNode.next;
        current++;
        if(current==k){
            temp=currentNode.next;
            currentNode.next=null;
            ListNode newHead= reverseLL(startNode);
        }
    }
}
// @lc code=end
