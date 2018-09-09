/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        int num1, num2;
        ListNode dummy = new ListNode(0);
        ListNode p = dummy;
        while (l1 != null || l2 != null) {
            num1 = (l1 == null) ? 0 : l1.val;
            num2 = (l2 == null) ? 0 : l2.val;
            int curSum = num1 + num2 + carry;
            p.next = new ListNode(curSum % 10);
            p = p.next;
            carry = curSum / 10;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        if (carry != 0) p.next = new ListNode(carry);
        return dummy.next;
    }
}