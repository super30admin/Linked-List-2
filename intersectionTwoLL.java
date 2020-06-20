// Time Complexity : O(m+n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : I came up with the length idea, not the
// switch pointer idea, which was a good technique i learnt.


// Your code here along with comments explaining your approach

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
     
        ListNode ptr1=headA;
        ListNode ptr2=headB;
        
        while(ptr1!=ptr2)
        {
            ptr1=(ptr1==null)?headB:ptr1.next;
            ptr2=(ptr2==null)?headA:ptr2.next;
        }
        
        return ptr1;
    }
}