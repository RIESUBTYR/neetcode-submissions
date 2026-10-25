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
        ListNode output = new ListNode(0);
        ListNode curr = output;
        int minimum = 1005;
        int minListInd = -1;
        int k = lists.length;
        while(true)
        {
            minListInd = -1;
            for(int i=0;i<k;i++)
            {
                if(lists[i] != null){
                    ListNode nd = lists[i];
                    if(minimum>nd.val){
                        minimum = nd.val;
                        minListInd = i;
                    }
                }else{
                    continue;
                }
            }

            if(minListInd == -1){
                break;
            }
            ListNode node = lists[minListInd]; 
            lists[minListInd] = lists[minListInd].next;
            curr.next = node;
            curr = curr.next;
            minimum = 1005;
        }

        return output.next;
    
    }
}
