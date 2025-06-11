/*
  Time complexity: O(n)
  Space complexity: O(1)

  Code ran successfully on Leetcode: Yes

*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     public int val;
 *     public ListNode next;
 *     public ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode GetIntersectionNode(ListNode headA, ListNode headB) {
        int lengthA = GetListLength(headA);
        int lengthB = GetListLength(headB);
        
        ListNode shortList = (lengthA>lengthB)?headB:headA;
        ListNode longList = (lengthA>lengthB)?headA:headB;
        
        int difference = Math.Abs(lengthA-lengthB);
        
        while(difference>0)
        {
            difference--;
            longList=longList.next;
        }
        
        while(shortList!=null)
        {
            if(shortList==longList)
                return shortList;
            
            shortList=shortList.next;
            longList=longList.next;
        }
        
        return null;
    }
    
    public int GetListLength(ListNode head)
    {
        int length = 0;
        
        while(head!=null)
        {
            length++;
            head = head.next;
        }
        
        return length;
    }
    
}
