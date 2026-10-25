/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode reverseList(ListNode head) {


        if(head == null || head.next == null){
            return head;
        }

        ListNode prev = new ListNode(head.val,null);
        ListNode tmp = head.next;
        ListNode newhead = new ListNode(tmp.val,prev);
        while(tmp.next != null){
            prev = newhead;
            tmp = tmp.next;
            newhead = new ListNode(tmp.val,prev);
        }

        return newhead;
        
    }
}
