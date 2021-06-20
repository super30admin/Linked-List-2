// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Nope


// Your code here along with comments explaining your approach
// create a dummy head that has next point to the given head
// move the fast pointer till it reached the end of the list and reduce the value of n by 1
// move the slow pointer only if n < 0, this helps to create the required gap between slow and fast pointers
// point slow pointer accordingly to skip the node to be deleted
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null)
            return null;
        
        ListNode dummyHead = new ListNode(-1, head);
        ListNode slow = dummyHead;
        ListNode fast = dummyHead;
        
        while(fast != null) {
            fast = fast.next;
            if(n-- < 0) {
                slow = slow.next;
            }
            
        }
        
        slow.next = slow.next.next;
        return dummyHead.next;
    }
}