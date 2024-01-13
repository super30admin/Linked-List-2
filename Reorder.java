/*
* Approach:
*  1. If we have a tail pointer coming inwards, we can easily merge them
* 
*  2. SO, reverse the linkedlist to acheive above functionality,
    Best way is to reverse the linkedlist from the middle.
* 
*  3. Steps: 
        Find Middle
        Reverse from middle
        Merge
* 
* 
* Did this code successfully run on Leetcode : YES
* 
* Any problem you faced while coding this : NO
* 
* Time Complexity: O(n)
* 
* Space Complexity: O(1)
* 
*/

public class Reorder {
    private ListNode getMiddleOfLinkedList(ListNode head){
        ListNode slow = head, fast = head;

        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    private ListNode reverseLinkedList(ListNode head){
        if(head.next == null)
            return head;

        ListNode reversed = reverseLinkedList(head.next);

        head.next.next = head;
        head.next = null;

        return reversed;
    }

    public void reorderList(ListNode head) {
        ListNode middle = getMiddleOfLinkedList(head);

        ListNode head2 = reverseLinkedList(middle);

        ListNode head1 = head;

        while(head2.next !=null){
            ListNode h1temp = head1.next;
            ListNode h2temp = head2.next;

            head1.next = head2;
            head2.next = h1temp;

            head1 = h1temp;
            head2 = h2temp;
        }
    }
}
