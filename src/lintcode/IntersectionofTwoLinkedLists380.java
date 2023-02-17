package lintcode;

public class IntersectionofTwoLinkedLists380 {

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
     * @param headA: the first list
     * @param headB: the second list
     * @return: a ListNode
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // write your code here
        if (headA == null || headB == null){
            return null;
        }

        int LenA = 0;
        int LenB = 0;
        ListNode ListA = headA;
        ListNode ListB = headB;

        while (ListA != null){
            ListA = ListA.next;
            LenA++;
        }
        while (ListB != null){
            ListB = ListB.next;
            LenB++;
        }

        if (LenA > LenB) {
            int delta = LenA - LenB;
            for (int i=1;i<=delta;i++){
                headA = headA.next;
            }
        }else{
            int delta = LenB - LenA;
            for (int i=1;i<=delta;i++){
                headB = headB.next;
            }
        }
        while (headA != headB){
            headA = headA.next;
            headB = headB.next;
        }

        return headA;

    }
}