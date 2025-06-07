// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None


// Your code here along with comments explaining your approach
class Solution {
    public void reorderList(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while(fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode mid = slow.next;
        mid = reverse(mid);
        slow.next = null;
        fast = head;
        while(mid != null){
            ListNode temp = fast.next;
            fast.next = mid;
            mid = fast.next.next;
            fast.next.next = temp;
            fast = temp;
        }
    }
    public ListNode reverse(ListNode mid){
        ListNode prev = null;
        while(mid != null){
            ListNode temp = mid.next;
            mid.next = prev;
            prev = mid;
            mid = temp;
        }
        return prev;
    }
}
