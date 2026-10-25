class LRUCache {

    class Node{
        int key;
        int val;
        Node next;
        Node prev;

        public Node(int key,int value){
            this.key = key;
            this.val = value;
            this.next = null;
            this.prev = null;
        }
    }

    Node head;
    Node tail;
    int capacity;
    int size;
    Node[] hash;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.hash = new Node[1001];
        this.size = 0;
        this.head = new Node(0,0);
        this.tail = new Node(0,0);
        this.head.next = tail;
        this.tail.prev = head;
    }

    public void insert(Node node){
        Node prev = this.tail.prev;
        prev.next = node;
        node.prev = prev;
        node.next = this.tail;
        this.tail.prev = node;
    }

    public void remove(Node node){
        Node prev = node.prev;
        Node next = node.next;
        prev.next = next;
        next.prev = prev;
    }
    
    public int get(int key) {
        System.out.println("G");
        if(this.hash[key]==null) return -1;
        Node nd = this.hash[key];
        remove(nd);
        insert(nd);
        return nd.val;
    }
    
    public void put(int key, int value) {
        System.out.println("P");
        if(this.hash[key]!= null){
            remove(hash[key]);
            this.size--;
        }
        this.size++;
        Node nd = new Node(key,value);
        this.hash[key] = nd;
        insert(nd);
        if(this.size>this.capacity){
            hash[head.next.key] = null;
            remove(head.next);
            size--;
        }
    }
}
