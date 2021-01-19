/**
Leetcode: https://leetcode.com/problems/intersection-of-two-linked-lists/

Intersection of two linkedlist

Time Complexity : O(N)
Space Complexity : O(1)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

**/
public class Solution 
{
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) 
    {
        int count1 = 0;
        int count2 = 0;
        
        ListNode temp1 = headA;
        ListNode temp2 = headB;
        
        
        
        while(temp1 != null || temp2!= null)
        {
            if(temp1 != null && temp2!= null)
            {
                count1++; count2++; 
                
                temp1 = temp1.next;
                temp2 = temp2.next;
            }
            else if( temp1 != null)
            {
                count1++;
                temp1 = temp1.next;
            }
            else
            {
                count2++;
                temp2 = temp2.next;
            }
        }
        
        temp1 = headA;
        temp2 = headB;
        
        if( count1 > count2)
        {
            int diff = count1 - count2;
            
            while(diff > 0)
            {
                temp1 = temp1.next;
                diff--;
            }
        }
        else
        {
            int diff = count2 - count1;
            
            while(diff > 0)
            {
                temp2 = temp2.next;
                diff--;
            }
        }
        
        
        while(temp1 != temp2)
        {
            temp1 = temp1.next;
            temp2 = temp2.next;
        }
        
        return temp1;
    }
}