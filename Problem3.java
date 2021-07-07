// Time Complexity :
//      m is the number of nodes in headA
//		n is the number of nodes in headB
//      getIntersectionNode() - O(m + n)
//      
// Space Complexity :
//      getIntersectionNode() - O(1)
//
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        
        if(headA == null || headB == null)
            return null;
        
        if(headA == headB)
            return headA;
        
        ListNode a = headA, b = headB;
        
        while(a != b)
        {
            if(a == null)
                a = headB;
            if(b == null)
                b = headA;
            
            if(a != b)
            {
                a = a.next;
                b = b.next;
            }
        }
        
        return a;
    }
}
