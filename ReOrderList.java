// Time Complexity : O(n)
// Space Complexity : O(1)
// Method used : Slow, fast pointer approach

class Solution {
    public void reorderList(ListNode head) {
        
        ListNode slow, fast;
        slow = fast = head;

        while(fast != null && fast.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode prev = null, curr = slow.next, next;
        slow.next = null;

        while(curr != null)
        {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        ListNode ptr1, temp;

        ptr1 = slow = head;
        fast = prev;

        while(ptr1 != null && fast != null)
        {
            slow = ptr1;
            ptr1 = ptr1.next;
            slow.next = fast;

            temp = ptr1;
            ptr1 = fast;
            fast = temp;
        }

    }
}