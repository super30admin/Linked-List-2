/**
Time Complexity : O(1)
Space Complexity : O(1) 
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No
**/
class Solution 
{
    public void reorderList(ListNode head) 
    {
        ListNode temp = head;
        ListNode prev = null;
        int count = 0;
        
        while(temp != null)
        {
            ListNode temp2 = temp.next;
            
            ListNode newnode = new ListNode(temp.val);
            newnode.next = prev;
            prev = newnode;
            
            temp = temp.next;
            count++;
        }
        
        ListNode revHead = prev;
        temp = head;
        
        int countBck = count;
        
        while(count >0)
        {
            ListNode bck1 = temp.next;
            ListNode bck2 = revHead.next;
            
            temp.next = revHead;
            revHead.next = bck1;
            
            temp = bck1;
            revHead = bck2;
            
            count--;
        }
        
        temp = head;
        
        for(int i=1; i< countBck; i++)
        {
            temp = temp.next;
        }
        
        temp.next = null;
        
        
    }
}