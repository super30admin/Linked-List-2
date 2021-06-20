// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Nope


// Your code here along with comments explaining your approach
// Use slow and fast pointers to check if the intersection exists
// if yes, reset slow pointer to head and iterate till slow == fast, return slow or fast pointer
// this algorithm to detect the cycle is know as Floyd's cycle detection algorithm
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if(head == null)
            return null;
        
        ListNode slow = head;
        ListNode fast = head;
        boolean flag = false;
        
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(fast == slow) {
                flag = true;
                break;
            }
        }
        
        if(!flag) 
            return null;
        
        slow = head;
        while(fast != slow) {
            slow = slow.next;
            fast = fast.next;
        }
        
        return fast;
    }
}