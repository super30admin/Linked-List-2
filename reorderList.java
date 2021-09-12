// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach

class Solution {
    public void reorderList(ListNode head) {
        if(head == null || head.next == null) return;
        ListNode slow = head;
        ListNode fast = head;

        // 1. find middle
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        // 2. reverse second half
        fast = reverse(slow.next);
        slow.next = null;
        slow = head;

        ListNode temp = null;
        // 3. Merge the two lists
        while(fast != null){
            temp = slow.next;
            slow.next = fast;
            fast = fast.next;
            slow.next.next = temp;
            slow = temp;
        }
        // void func
    }
    private ListNode reverse(ListNode head){
        ListNode prev = null;
        ListNode curr = head;
        ListNode fast = head.next;
        while(fast != null){
            curr.next = prev;
            prev = curr;
            curr = fast;
            fast = fast.next;
        }
        curr.next = prev;
        return curr;
    }
}