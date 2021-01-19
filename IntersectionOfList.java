// Time Complexity : O(n) // for dfs
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        
        if(headA == null || headB == null) return null;
        ListNode ptrA = headA;
        ListNode ptrB = headB;
        
        while(ptrA!=null || ptrB!=null)
        {    
             if(ptrA==null) ptrA = headB;
             if(ptrB==null) ptrB = headA;
             if(ptrA == ptrB) return ptrA;
             ptrA= ptrA.next;
             ptrB= ptrB.next;
            
        }
        
        
        // if(ptrA == ptrB)
        //     return ptrA;
        
        return null;
    }
}