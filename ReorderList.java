// Time Complexity : O(N), N nodes in the list
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
// Approach :
// We need to find the middle of the list
// Reverse the second half of the list
// Merge the first and second half of the list
public class ReorderList {
    public void reorderList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        // move fast and slow to find the middle node
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        while (fast!= null) {
            slow = slow.next;
            fast = fast.next;
            if(fast == null){
                break;
            }
            fast = fast.next;
        }

        ListNode headB = slow;
        ListNode prev = null;
        while (headB != null) {
            ListNode temp = headB.next;
            headB.next = prev;
            prev = headB;
            headB = temp;
        }
        // make sure you disconnect the first half of the list
        // else you will get cycle in the list after merging
        slow.next = null;

        // prev has the head of the reversed list
        headB = prev;
        ListNode headA = head;
        while (headA != null) {
            ListNode tempA = headA.next;
            ListNode tempB = headB.next;
            headA.next = headB;
            headB.next = tempA;
            headB = tempB;
            headA = tempA;
        }
    }
}
