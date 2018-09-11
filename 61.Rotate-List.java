/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        int len = 0;
        ListNode fast = dummy;
        while (fast.next != null) {
            fast = fast.next;
            len++;
        }
        k = k % len;
        ListNode slow = dummy;
        
        for (int i = 0; i < len - k; i++) slow = slow.next;
        fast.next = dummy.next;
        dummy.next = slow.next;
        slow.next = null;
        return dummy.next;
    }
}