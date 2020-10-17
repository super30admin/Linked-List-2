// Time Complexity :O(n+m)
// Space Complexity :1
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :I was getting wrong answer because of mistake in using lengths

// Your code here along with comments explaining your approach


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB)
    {
        //taking curr pointer pointing to head of list A
        ListNode curr=headA;
        //initialising variables LenA and LenB to 0 which will give us length of list A and length of list B respectively
        int LenA=0;
        int LenB=0;
        //if(headA==null || headB==null  ) return null;
        //traversing list A until curr is null to calculate the length
        while(curr!=null)
        {
            curr=curr.next;
            LenA++;
        }
        //making current pointer point to list B now
        curr=headB;
         //traversing list A until curr is null to calculate the length
        while(curr!=null)
        {
            curr=curr.next;
            LenB++;
        }
        
       //we have length of both the arrays with us 
        //now if listA has more elements than the other one we increment its head until it reaches equal to the starting point of other list
        while(LenA>LenB)
        {
         headA=headA.next;
            LenA--;
        }
        //same as we did with other list
        while(LenB>LenA)
        {
         headB=headB.next;
            LenB--;
        }
        //now we increment head of A and B until they both point to the same node
        while(headA!=headB)
        {
            headA=headA.next;
            headB=headB.next;
            
        }
        //we got our point of intersection,we can return return headB as well
        return headA;
   }
}