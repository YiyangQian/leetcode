/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    //head is begin of sorted, sortedEnd is end of sorted
    public ListNode insertionSortList(ListNode head) {
        if (head == null) return null;
        ListNode sortedEnd = head;
        while (sortedEnd.next != null) {
            ListNode toInsert = sortedEnd.next;
            
            if (toInsert.val <= head.val) {
                sortedEnd.next = sortedEnd.next.next;
                toInsert.next = head;
                head = toInsert;
            } 
            else if (toInsert.val > sortedEnd.val) {
                sortedEnd = sortedEnd.next;
            } else {
                ListNode p = head;
                while (p != sortedEnd) {
                    if (p.val <= toInsert.val && p.next.val >= toInsert.val) {
                        sortedEnd.next = sortedEnd.next.next;
                        ListNode originalNext = p.next;
                        p.next = toInsert;
                        toInsert.next = originalNext;
                        break;
                    } else {
                        p = p.next;
                        
                    }
                }
            }
        }
        return head;
    }
}

// 4         2            1        3
// h, end    toInsert

// 2    4             1           3
// head  sortedEnd   toInsert

// 1     2       4             
// head           sortedEnd
