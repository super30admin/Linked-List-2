// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public class Solution 
{
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) 
    {
        
        if(headA == null || headB == null)
            return null;
        
        List<ListNode> list = new LinkedList<>();
        
        ListNode temp1= headA;
        ListNode temp2= headB;
        
        while(temp1 != null)
        {
            list.add(temp1);
            temp1 = temp1.next;
        }
        
        while(temp2 != null)
        {
            if(list.contains(temp2))
                return temp2;
            
            temp2 = temp2.next;
        }
        
        return null;
        
    }
}