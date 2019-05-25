/*
 * [146] LRU Cache
 *
 * https://leetcode.com/problems/lru-cache/description/
 *
 * algorithms
 * Hard (25.34%)
 * Total Accepted:    295K
 * Total Submissions: 1.2M
 * Testcase Example:  '["LRUCache","put","put","get","put","get","put","get","get","get"]\n[[2],[1,1],[2,2],[1],[3,3],[2],[4,4],[1],[3],[4]]'
 *
 * Design and implement a data structure for Least Recently Used (LRU) cache.
 * It should support the following operations: get and put.
 * 
 * get(key) - Get the value (will always be positive) of the key if the key
 * exists in the cache, otherwise return -1.
 * put(key, value) - Set or insert the value if the key is not already present.
 * When the cache reached its capacity, it should invalidate the least recently
 * used item before inserting a new item.
 * 
 * The cache is initialized with a positive capacity.
 * 
 * Follow up:
 * Could you do both operations in O(1) time complexity?
 * 
 * Example:
 * 
 * 
 * LRUCache cache = new LRUCache(2);
 * 
 * cache.put(1, 1);
 * cache.put(2, 2);
 * cache.get(1);       // returns 1
 * cache.put(3, 3);    // evicts key 2
 * cache.get(2);       // returns -1 (not found)
 * cache.put(4, 4);    // evicts key 1
 * cache.get(1);       // returns -1 (not found)
 * cache.get(3);       // returns 3
 * cache.get(4);       // returns 4
 * 
 * 
 * 
 */
class LRUCache {
    
    class Node {
        int key;
        int value;
        Node pre;
        Node next;

        Node() {
            
        }

        Node(int a, int b) {
            key = a;
            value = b;
        }
    }
    
    class DoubleLinkedList {
        Node head;
        Node tail;
        int size;
        
        DoubleLinkedList() {
            head = new Node();
            tail = new Node();
            head.next = tail;
            tail.pre = head;
            size = 0;
        }
        
        void insertToFront(Node node) {
            Node next = head.next;
            head.next = node;
            node.pre = head;
            node.next = next;
            next.pre = node;
            size++;
        }
        
        Node removeTail() {
            Node toRemove = tail.pre;
            Node ahead = tail.pre.pre;
            ahead.next = tail;
            tail.pre = ahead;
            size--;
            return toRemove;
        }
        
        void remove(Node node) {
            Node ahead = node.pre;
            Node after = node.next;
            ahead.next = after;
            after.pre = ahead;
            size--;
        }
    }
    
    DoubleLinkedList l;
    Map<Integer, Node> map;
    final int CAPACITY;

    public LRUCache(int capacity) {
        this.CAPACITY = capacity;
        l = new DoubleLinkedList();
        map = new HashMap<>();
    }
    
    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        Node cur = map.get(key);
        l.remove(cur);
        l.insertToFront(cur);
        return cur.value;
    }
    
    public void put(int key, int value) {
        Node cur;
        if (map.containsKey(key)) {
            cur = map.get(key);
            cur.value = value;
            l.remove(cur);
            l.insertToFront(cur);
        } else {
            cur = new Node(key, value);
            map.put(key, cur);
            l.insertToFront(cur);
            if (l.size > CAPACITY) {
                Node removed = l.removeTail();
                map.remove(removed.key);
            }
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
