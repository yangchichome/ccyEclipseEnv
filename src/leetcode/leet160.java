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
        int lenA = 0;
        int lenB = 0;

        ListNode A = headA;
        ListNode B = headB;
        while(A != null){
            lenA++;
            A = A.next;
        }
        while(B != null){
            lenB++;
            B = B.next;
        }
        A = headA;
        B = headB;
        if (lenA > lenB){
            while(lenA != lenB){
                lenA--;
                A = A.next;
            }
        }else{
            while(lenA != lenB){
                lenB--;
                B = B.next;
            }
        }

        for (int i=0; i<lenA; i++){
            if (A == B){
                return A;
            }else{
                A = A.next;
                B = B.next;
            }
        }

        return null;
        
    }
}