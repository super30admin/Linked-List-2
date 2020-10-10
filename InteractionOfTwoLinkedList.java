// Time Complexity : O(m+n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public class Solution {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        if(headA == null || headB == null)
        {
            return null;
        }

        ListNode pa = headA;
        ListNode pb = headB;

        while(pa != pb)
        {
            if(pa == null)
            {
                pa = headB;
            }
            else if(pb == null)
            {
                pb = headA;
            }
            else
            {
                pa = pa.next;
                pb = pb.next;
            }
        }

        return pa;
    }
}
