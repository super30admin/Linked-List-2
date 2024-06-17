/**
 TC - O(n), SC - O(1)
 */

 class ReorderList {
    public void reorderList(ListNode head) {

        if(head == null || head.next == null)
            return;

        //Find mid of the linked list

        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        //Reverse the list after the mid position
        ListNode curr = slow.next;
        ListNode prev = null;

        while(curr != null) {
            fast = curr.next;
            curr.next = prev;
            prev = curr;
            curr = fast;
        }

        //Disassociate the 1st half of LL with the 2nd half
        slow.next = null;

        slow = head;
        fast = prev;

        //Merge two halves of the LL
        while(fast != null) {
            ListNode temp = slow.next;
            slow.next = fast;
            fast = fast.next;
            slow.next.next = temp;
            slow = temp;
        }

    }
}