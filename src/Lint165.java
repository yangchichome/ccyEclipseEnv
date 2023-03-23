
public class Lint165 {

}
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

public class Solution {
    /**
     * @param l1: ListNode l1 is the head of the linked list
     * @param l2: ListNode l2 is the head of the linked list
     * @return: ListNode head of linked list
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // write your code here
        ListNode dummy = new ListNode(0);
        ListNode result = dummy;

        while (l1 != null && l2 != null){
            if (l1.val <= l2.val){

                result.next = l1;
                l1 = l1.next;
            }else{

                result.next = l2;
                l2 = l2.next;
            }

            result = result.next;
        }

        if (l1 != null){
            result.next = l1;
        }
        if (l2 != null){
            result.next = l2;
        }

        return dummy.next;
    }

}