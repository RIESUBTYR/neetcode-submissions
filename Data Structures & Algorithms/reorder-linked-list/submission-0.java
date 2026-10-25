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
    public void reorderList(ListNode head) {

        if (head == null || head.next == null) return;
        int c =0;
        ListNode p1 = head;
        ListNode p2 = head;

        while(p1!= null && p1.next!=null ){
            p1 = p1.next.next;
            p2= p2.next;
        }

        ListNode prev = null;
        ListNode curr = p2;
        while(curr != null){
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }

        ListNode list1= head,list2= prev;

        while(list2.next!=null){
            ListNode tmp1 = list1.next;
            ListNode tmp2 = list2.next;
            list1.next = list2;
            list2.next = tmp1;
            list1 = tmp1;
            list2 = tmp2;
        }
    }
}
