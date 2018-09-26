/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void reorderList(ListNode head) {
        if (head == null) return;
        ListNode mid = getMid(head);
        //reverse after mid
        reverse(mid);
        insertAll(head, mid);
    }
    
    public ListNode getMid(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
    
    public void reverse(ListNode head) {
        ListNode pre = null;
        ListNode cur = head.next;
        if (cur == null || cur.next == null) {
            return;
        }
        while (cur != null) {
            // System.out.println(cur.val);
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        head.next = pre;
    }
    
    public void insertAll(ListNode head, ListNode mid) {
        while (mid.next != null) {
            ListNode removed = removeNext(mid);
            head = insertToNext(head, removed);
        }
    }
    
    public ListNode removeNext(ListNode node) {
        ListNode res = node.next;
        node.next = node.next.next;
        return res;
    }
    
    public ListNode insertToNext(ListNode head, ListNode removed) {
        ListNode originalNext = head.next;
        head.next = removed;
        removed.next = originalNext;
        return originalNext;
    }
}

// 1 -> 2 -> 3 -> 4 

// null <- 1   -> 2 
//  pre    cur  next
//         pre  cur
