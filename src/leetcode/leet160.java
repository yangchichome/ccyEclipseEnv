package leetcode;

public class leet160 {

}
/**
 * Definition for singly-linked list.
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
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int l1 = 0;
        int l2 = 0;
        ListNode A = headA;
        ListNode B = headB;
        while(A != null){
            l1++;
            A = A.next;
        }
        while(B != null){
            l2++;
            B = B.next;
        }        

        if (l1 > l2){
            int del = l1 -l2;
            while(del > 0){
                headA = headA.next;
                del--;
            }
        }
        if (l2 > l1){
            int del = l2 -l1;
            while(del > 0){
                headB = headB.next;
                del--;
            }
        }

        while(headA != headB){
            headA = headA.next;
            headB = headB.next;
        }

        return headA;
    }
}