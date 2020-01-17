// Time Complexity :
//      m is the number of nodes in headA
//		n is the number of nodes in headB
//      getIntersectionNode() - O(m + n)
//      
// Space Complexity :
//      getIntersectionNode() - O(n)
//
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public class Solution {
    HashSet<ListNode> set = new HashSet<>();
    
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null)
            return null;
        
        if(headA == headB)
            return headA;
        
        while(headA != null)
        {
            set.add(headA);
            headA = headA.next;
        }
        
        while(headB != null)
        {
            if(set.contains(headB))
                return headB;
            
            headB = headB.next;
        }
        
        return null;
    }
}
