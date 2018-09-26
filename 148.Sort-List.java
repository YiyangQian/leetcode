/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) 
            return head;
        //pre is the one before mid, end of the first list
        ListNode pre = null, slow = head, fast = head;
        while(fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        pre.next = null;
        
        ListNode left = sortList(head);
        ListNode right = sortList(slow);
        ListNode res = merge(left, right);
        return res;
    }
    
    public ListNode merge(ListNode l, ListNode r) {
        ListNode dummy = new ListNode(0);
        ListNode p = dummy;
        ListNode p1 = l;
        ListNode p2 = r;
        while (p1 != null || p2 != null) {
            int val1 = (p1 == null) ? Integer.MAX_VALUE : p1.val;
            int val2 = (p2 == null) ? Integer.MAX_VALUE : p2.val;
            if (val1 <= val2) {
                p.next = p1;
                p1 = p1.next;
                p = p.next;
            } else {
                p.next = p2;
                p2 = p2.next;
                p = p.next;
            }
        }
        return dummy.next;
    }
}
