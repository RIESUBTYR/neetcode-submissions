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
    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode pointer = head;
        int size=0;
        while(pointer!=null){
            size++;
            pointer = pointer.next;
        }

        if(size-n == 0){
            return head.next;
        }

        pointer = head;
        int i =0;
        while(pointer.next!=null){
            if(i+1 == size-n){
                pointer.next = pointer.next.next;
                break;
            }
            i++;
            pointer= pointer.next;
        }

        

        return head;
    }
}
