package leetcode;

public class leet142 {

}
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
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null){
            return null;
        }

        ListNode slow = head;
        ListNode fast = head.next;

        // (a+b)*2 = a+b+c -1 ==> a = c- b -1
        // (a+b)*2 = a+b+c  ==> a = c- b 
        while(fast != slow){
            if(fast == null || fast.next == null)
                return null;
            slow = slow.next;
            fast = fast.next.next;
        }

        if (fast == null){
            return null;
        }

        slow = head;
        while(slow != fast.next){
            fast = fast.next;
            slow = slow.next;
        }

        return slow;
    }
}