/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        int length = getLength(head);
        int beginOfSecond = (length % 2 == 0) ? length / 2 : length / 2 + 1;
        ListNode p = head;
        for (int i = 0; i < beginOfSecond; i++) {
            p = p.next;
        }
        p = reverseListNode(p);
        while (p != null) {
            if (p.val != head.val)
                return false;
            p = p.next;
            head = head.next;
        }
        return true;
    }

    public int getLength(ListNode head) {
        int count = 0;
        while (head != null) {
            count++;
            head = head.next;
        }
        return count;
    }

    public ListNode reverseListNode(ListNode head) {
        if (head == null)
            return null;
        ListNode pre = null;
        ListNode next = head.next;
        while (head != null) {
            head.next = pre;
            pre = head;
            head = next;
            if (head != null)
                next = head.next;
        }
        return pre;
    }
}
