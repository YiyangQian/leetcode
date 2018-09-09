/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    //here slow is the pre of the one we want to delete
    //cause tail sitaution will make us unable to delete the tail if the pointer is at tail
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode fast, slow;
        fast = slow = dummy;
        for (int i = 0; i <= n; i++) fast = fast.next;
        while(fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }
}