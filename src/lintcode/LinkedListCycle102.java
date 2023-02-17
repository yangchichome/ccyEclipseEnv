package lintcode;

public class LinkedListCycle102 {

/**
 * Definition for ListNode
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

    /**
     * @param head: The first node of linked list.
     * @return: True if it has a cycle, or false
     */
    public boolean hasCycle(ListNode head) {
        // write your code here
        if (head == null || head.next == null){
            return false;
        }

        ListNode slow = head;
        ListNode faster = head.next;
        while (faster != slow) {

            if (faster.next == null || faster.next.next == null){
                return false;
            }
            slow = slow.next;
            faster = faster.next.next;

        }
        return true;
    }
}