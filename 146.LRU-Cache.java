class LRUCache {
    DoubleLinkedNode head;
    //time to move tail, 1. when first element got settled or 2. tail element got removed or moved
    DoubleLinkedNode tail;
    int Capacity;
     Map<Integer, DoubleLinkedNode> map;
    public LRUCache(int capacity) {
        this.Capacity = capacity;
        map = new HashMap<Integer, DoubleLinkedNode>();
    }
    
    public int get(int key) {
        if (head == null || !map.containsKey(key)) {
            return -1;
        } else {
            moveToHead(map.get(key));
            return map.get(key).val;
        }
    }
    
    public void moveToHead(DoubleLinkedNode cur) {
        if (cur == head) return;
        DoubleLinkedNode pre = cur.pre;
        DoubleLinkedNode next = cur.next;
        if (next == null) {
            tail = pre;
        } else {
            next.pre = pre;
        }
        pre.next = next;
        
        cur.next = head;
        head.pre = cur;
        head = cur;
    }
    
    public void removeLast() {
        DoubleLinkedNode pre = tail.pre;
        if (pre == null) {
            head = null;
            tail = null;
        } else {
            pre.next = null;
            tail = pre;    
        }
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            DoubleLinkedNode cur = map.get(key);
            cur.val = value;
            moveToHead(cur);
        } else {
            if (map.size() == Capacity) {
                map.remove(tail.key);
                removeLast();
                DoubleLinkedNode cur = new DoubleLinkedNode(key, value);
                cur.next = head; 
                if (head != null) head.pre = cur;
                head = cur;
                map.put(key, head);
            } else {
                DoubleLinkedNode cur = new DoubleLinkedNode(key, value);
                cur.next = head;
                if (head != null) {
                    head.pre = cur;        
                } else {
                    tail = cur;
                }
                head = cur;
                map.put(key, head);
            }
        }
    }
}

class DoubleLinkedNode {
    int key;
    int val;
    DoubleLinkedNode pre;
    DoubleLinkedNode next;
    DoubleLinkedNode (int x, int y) {
        this.key = x;
        this.val = y;
    };
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */