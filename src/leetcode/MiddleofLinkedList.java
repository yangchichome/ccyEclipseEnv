package leetcode;

public class MiddleofLinkedList {

    public ListNode middleNode(ListNode head) {
        ListNode slow = head, faster = head;
        while (faster != null && faster.next != null ){
            slow = slow.next;
            faster = faster.next.next;
        } 
        return slow;
    }
}