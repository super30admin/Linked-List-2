// Time Complexity : O(N), N is number of nodes in Linkedlist
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
// To arrange the linkedlist in this order, we first need to reverse the second half of the linked list. To find the second
// half of the list, we should find the middle of the linked list. I can find the middle of the linkedlist with the help of two pointers
// where one travels at the double pace than the other pointer. Once the fast pointer reaches the end,the slow pointer will be
// pointing to the middle element. After getting middle node, we can reverse the list from middle to the end of the list.
// After reversing we would have one pointer at the head of the list and one pointer at the end of the end of the list. Now we can
// start merging with the help of these two pointers and increment the pointers to point to next element in the list.
public class ReorderList {

    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;

        ListNode start = head;
        ListNode end = head;
        //Finding the middle
        while (end.next != null && end.next.next != null) {
            start = start.next;
            end = end.next.next;
        }

        // reverse the list
        end = reverseList(start.next);
        start.next = null;

        // Merge the two list
        start = head;
        while (end != null) {
            ListNode tempStart = start.next;

            start.next = end;
            end = end.next;
            start.next.next = tempStart;
            start = tempStart;
        }
    }

    public ListNode reverseList(ListNode start) {
        ListNode prev = null;

        while (start != null) {
            ListNode next = start.next;
            start.next = prev;
            prev = start;
            start = next;
        }

        return prev;

    }
}
