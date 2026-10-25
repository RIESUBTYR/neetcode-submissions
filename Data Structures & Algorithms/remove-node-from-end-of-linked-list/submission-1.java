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

        pointer = head;
        ListNode prev = null;
        int i =0;

        if(size == 1){
            return null;
        }
        if(size-n == 0){
            return head.next;
        }

        while(pointer.next!=null){
            prev = pointer;
            pointer= pointer.next;
            i++;
            if(i == size-n){
                prev.next = pointer.next;
                break;
            }
        }

        

        return head;
    }
}
