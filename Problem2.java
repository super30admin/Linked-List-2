// Time - O(N)
// Space - O(1)



class Solution {
    public void reorderList(ListNode head) {


        // base case
        if(head == null || head.next == null) return;

        // find the middle pointer

        ListNode slow = head;
        ListNode fast = head.next;

        while(fast != null && fast.next != null) {

            slow = slow.next;
            fast = fast.next.next;

        }

        // reverse the second part of thel list after the middle

        fast = reverse(slow.next);

        // merging the list

        // pointing the next pointer of slow to null
        slow.next = null;

        // resetting slow pointer to head
        slow = head;


        //merge operation
        while(fast != null) {

            ListNode temp = slow.next;
            slow.next = fast;
            fast = fast.next;
            slow.next.next = temp;
            slow = temp;

        }


    }


    private ListNode reverse(ListNode head) {
        ListNode current = head;
        ListNode fast = current.next;
        ListNode prev = null;

        while(fast != null) {

            current.next = prev;
            prev = current;
            current = fast;
            fast = fast.next;

        }

        current.next = prev;

        return current;


    }

}