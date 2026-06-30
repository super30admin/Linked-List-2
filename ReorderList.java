
// Time complexity: O(3n/2) = O(n)
// space complexity: O(1)
class Solution {
    public void reorderList(ListNode head) {
        
        ListNode slow = head;
        ListNode fast = head;

        // find mid point of the list
        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // find starting of two lists after reversing second one
        fast = reverse(slow.next);
        slow.next = null;
        slow = head;

        while(fast != null) {
            ListNode temp = slow.next;
            slow.next = fast;
            fast = fast.next;
            slow.next.next = temp;
            slow = temp;
        }
    }

    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while(curr != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }
   
}