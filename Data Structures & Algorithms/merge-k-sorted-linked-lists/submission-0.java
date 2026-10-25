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
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0){
            return null;
        }
        ListNode output = new ListNode(0);
        ListNode curr = output;
        boolean allSeen=false;
        int minimum = 1005;
        int minListInd = 0;
        int k = lists.length;
        boolean[] seen = new boolean[k];
        while(!allSeen)
        {
            for(int i=0;i<k;i++)
            {
                if(lists[i] != null){
                    ListNode nd = lists[i];
                    if(minimum>nd.val){
                        minimum = nd.val;
                        minListInd = i;
                    }
                }else{
                    seen[i] = true;
                }
            }
            allSeen = checkSeen(seen);
            ListNode node = lists[minListInd]; 
            if(node !=null){
                lists[minListInd] = lists[minListInd].next;
            }
            curr.next = node;
            curr = curr.next;
            minimum = 1005;
        }

        return output.next;
    
    }

    public boolean checkSeen(boolean[] seen){
        for(boolean see:seen){
            if(!see){
                return false;
            }
        }
        return true;
    }
}
