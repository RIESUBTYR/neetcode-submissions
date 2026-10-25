/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head == null){
            return null;
        }

        Map<Node,Integer> map = new HashMap();
        List<Node> list = new ArrayList();
        Node curr = head;
        int i = 0;
        while(curr != null){
            Node cp = new Node(curr.val);
            map.put(curr,i++);
            list.add(cp);
            curr = curr.next;
        }
        curr = head;

        Node output = list.get(0);

        for(int j=0;j<i;j++){
            Node node = list.get(j);
            node.next = curr.next !=null ?list.get(map.get(curr.next)):null;
            node.random = curr.random !=null?list.get(map.get(curr.random)):null;
            curr = curr.next;
        }
        
        return output;
    }
}
