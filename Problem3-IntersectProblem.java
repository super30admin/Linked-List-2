// Time Complexity : O(n*m)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Time limit exceeded
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode temp=null;
        ListNode temp2;
        
        while(headA != null)
    {
        
        while(headB != null)
        {
            if(headA == headB)
            {
                // found a matching node
                temp = headA;
                break;
            }
            else
                headB = headB.next;
        }
    }
    return temp;
    }
        
}