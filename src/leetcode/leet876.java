package leetcode;

public class leet876 {

}
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode faster = head;
        while (faster != null && faster.next != null) {
            slow = slow.next;
            faster = faster.next.next;
        }

        return slow;
    }
}