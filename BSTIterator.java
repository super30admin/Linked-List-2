//Time Complexity: O(n)
//Space Complexity: O(1)
//Program ran successfully
/*
    Algorithm: 1. The problem is solved in 3 steps: find the middle element of the list, reverse the second half of the list & merge both the lists.
               2. Middle is found by hare and tortoise method
               3. Reversing of the list is done by maintaining three pointers: slow,fast and previous
               4. Two lists are merged doing pointer manipulation
*/
class Solution {
    public void reorderList(ListNode head) {
        //edge cases
        if(head == null || head.next == null) return;
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        fast = reverse(slow.next);
        slow.next = null;
        slow = head;
        while(fast != null){
            ListNode temp = slow.next;
            slow.next = fast;
            fast = fast.next;
            slow.next.next = temp;
            slow = temp;
        }
        return;
    }
    private ListNode reverse(ListNode head){
        ListNode prev = null;
        ListNode slow = head;
        ListNode fast = head.next;
        while(fast!=null){
            slow.next = prev;
            prev = slow;
            slow = fast;
            fast = fast.next;
        }
        slow.next = prev;
        return slow;
    }
}
