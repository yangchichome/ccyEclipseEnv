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
        
        ListNode A = headA;
        ListNode B = headB;
        int lenA = 1;
        int lenB = 1;
        while (A.next != null || B.next != null){
            if (A.next != null){
                A = A.next;
                lenA++;
            }
            if (B.next != null){
                B = B.next;
                lenB++;
            }
        }

        A = headA;
        B = headB;
        if (lenB > lenA) {
            while(lenB > lenA){
                lenB--;
                B = B.next;
            }
        }else if (lenA > lenB){
            while(lenA > lenB){
                lenA--;
                A = A.next;
            }
        }

        while (lenA > 0 && A != B){
            lenA--;
            A = A.next;
            B = B.next;
        }

        return A;
    }
}