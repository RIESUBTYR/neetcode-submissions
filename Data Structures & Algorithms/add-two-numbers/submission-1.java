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
        ListNode p3 = new ListNode();
        ListNode prev = null;
        ListNode output = p3 ;
        boolean init=false;
        while(p1!=null && p2!=null){
            int add = p1.val+p2.val+carry;
            int sum = add%10;
            System.out.printf("%d+%d,%d,%d\n",p1.val,p2.val,sum,carry);
            prev = p3;
            p3.val = sum;
            p3.next = new ListNode();
            p3 = p3.next;
            carry = add/10;
            p1 = p1.next;
            p2 = p2.next;
            
        }

        if(p1!=null){
            while(p1!=null){
                int add = p1.val+carry;
                int sum = add%10;
                carry = add/10;
                System.out.printf("%d+%d,%d\n",p1.val,carry,sum);
                prev = p3;
                p3.val = sum;
                p3.next = new ListNode();
                p3 = p3.next;
                p1 = p1.next;
            }
        }
        if(p2!=null){
            while(p2!=null){
                int add = p2.val+carry;
                int sum = add%10;
                carry = add/10;
                prev = p3;
                p3.val = sum;
                p3.next = new ListNode();
                p3 = p3.next;
                p2 = p2.next;
            }
        }
        

        if(carry !=0){
            p3.val = carry;
        }
        else{
            prev.next= null;
        }

        return output;
    }
}
