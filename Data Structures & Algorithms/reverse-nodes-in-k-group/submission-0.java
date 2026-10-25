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
    public ListNode reverseKGroup(ListNode head, int k) {

        int size=0;
        ListNode curr=head;
        while(curr!=null){
            size++;
            curr = curr.next;
        }
        int grps = size/k;
        curr = head;
        ListNode connector = null;
        ListNode output = null;
        for(int i =0; i<grps; i++){
            System.out.println("L1");
            ListNode start = curr;
            ListNode part = curr;
            ListNode prev = null;
            for(int j=0;j<k;j++){
                curr = curr.next;
                ListNode tmp = part.next;
                part.next = prev;
                prev = part;
                part = tmp;
            }
            if(connector != null){
                connector.next = prev;
            }else{
                output = prev;
            }
            connector = start;
        }
        if(curr !=null){
            connector.next = curr;
        }
        return output;
    }
}
