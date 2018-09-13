/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode endofSmaller = dummy;
        ListNode p = dummy;
        //we always deal with p.next
        while (p.next != null) {
            if (p.next.val >= x) {
                p = p.next;                
            } else {
                if (p == endofSmaller) {
                    p = p.next;
                    endofSmaller = endofSmaller.next;
                } else {
                    //add p.next to end of smaller
                    //p stays at same position
                    ListNode smallerOne = p.next;
                    ListNode tempt = endofSmaller.next;
                    p.next = p.next.next;
                    endofSmaller.next = smallerOne;
                    endofSmaller = endofSmaller.next;
                    endofSmaller.next = tempt;
                }
            }
        }
        return dummy.next;
    }
}