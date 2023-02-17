package leetcode;

public class LinkedListCycleII142 {

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null){
            return null;
        }

        ListNode slow = head;
        ListNode faster = head.next;

        while (faster != slow){
            if (faster == null || faster.next == null){
                return null;
            }else{
                faster = faster.next.next;
                slow = slow.next;
            }
        }

        while (head != slow.next){
            head = head.next;
            slow = slow.next;
        }       

        return head;
    }
}