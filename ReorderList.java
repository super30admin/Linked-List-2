// Approach : first we find the middle, then we reverse or reorder the list.
// then we merge the two halves
/*
Middle → O(n/2)
Reverse → O(n/2)
Merge → O(n/2)

Time Complexity: O(n)
 */

// Space : O(1), no extra data structure needed


class Solution {
    public void reorderList(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null){ // identify the middle
            slow = slow.next; // 1x speed
            fast = fast.next.next;  // 2x speed
        }

        ListNode reverseHead = reverse(slow.next);
        slow.next = null;

        fast = reverseHead;
        slow = head;

        // reorder it
        while(fast != null){
            ListNode temp = slow.next;
            slow.next = fast;
            fast = fast.next;
            slow.next.next = temp;
            slow = temp;
        }     
    }

    private ListNode reverse(ListNode head){
        ListNode prev = null;
        ListNode curr = head;

        while(curr != null){
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }

        return prev;
    }
}