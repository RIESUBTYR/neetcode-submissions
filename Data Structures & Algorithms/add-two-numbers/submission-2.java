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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry =0;

        ListNode p1 = l1;
        ListNode p2 = l2;
        ListNode output = new ListNode();
        ListNode p3 = output ;
        boolean init=false;
        while(p1!=null || p2!=null || carry !=0 ){

            int n1= p1!=null ? p1.val : 0;
            int n2 = p2!=null ? p2.val : 0;

            int add = n1+n2+carry;
            carry = add/10;
             add = add%10;
            p3.next = new ListNode(add);

            p3 = p3.next;
            p1 =  p1!=null ? p1.next : null;
            p2 =  p2!=null ? p2.next : null;
        }
        return output.next;
    }
}
