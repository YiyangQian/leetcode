/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0 || lists == null) return null;
        ListNode cur = lists[0]; 
        for (int i = 1; i < lists.length; i++) {
            cur = merge(cur, lists[i]);
        }
        return cur;
    }
    
    public ListNode merge(ListNode p1, ListNode p2) {
        ListNode dummy = new ListNode(0);
        ListNode p = dummy;
        while(p1 != null || p2 != null) {
            int val1 = p1 == null ? Integer.MAX_VALUE : p1.val;
            int val2 = p2 == null ? Integer.MAX_VALUE : p2.val;
            if (val1 < val2) {
                p.next = p1;
                p1 = p1.next;
            } else {
                p.next = p2;
                p2 = p2.next;
            }
            p = p.next;
        }
        return dummy.next;
    }
}