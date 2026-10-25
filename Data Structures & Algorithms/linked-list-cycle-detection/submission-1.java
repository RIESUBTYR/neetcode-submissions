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
    public boolean hasCycle(ListNode head) {

        if(head.next == null){
            return false;
        }

        ListNode turtle= head;
        ListNode rabbit= head;

        while(rabbit !=null && turtle!=null){
            turtle= turtle.next;
            rabbit = rabbit.next;

            if(rabbit == null){
                return false;
            }
            else{
                rabbit = rabbit.next;
            }

            if(turtle == rabbit){
                return true;
            }
        }
        
        return false;
    }
}
