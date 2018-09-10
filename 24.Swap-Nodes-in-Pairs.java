/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode first = head;
        while (first != null) {
            ListNode second = first.next;
            if (second == null) break;
            ListNode next = second.next;
            
            pre.next = second;
            first.next = next;
            second.next = first;
            
            pre = first;
            first = next;
        }
        return dummy.next;
    }
}