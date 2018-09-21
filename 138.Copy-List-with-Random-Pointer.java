/**
 * Definition for singly-linked list with a random pointer. class RandomListNode
 * { int label; RandomListNode next, random; RandomListNode(int x) { this.label
 * = x; } };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        RandomListNode dummy = new RandomListNode(0);
        RandomListNode p = head;
        RandomListNode iterator = dummy;
        Map<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
        while (p != null) {
            RandomListNode cur = new RandomListNode(p.label);
            iterator.next = cur;
            map.put(p, cur);
            p = p.next;
            iterator = iterator.next;
        }
        p = head;
        iterator = dummy.next;
        while (p != null) {
            if (p.random != null)
                iterator.random = map.get(p.random);
            p = p.next;
            iterator = iterator.next;
        }
        return dummy.next;
    }
}