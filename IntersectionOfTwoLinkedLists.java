// Time Complexity :O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
// In this approach we use two pointers. We keep boht the pointers at the head of two linked lists. The goal here is for both the pointers to go 
// over equal number of elements , so whenever the pointer 1 reaches the end we make it go through the second list and when pointer 2 reaches the end
// we make it go through the first list. In this way boht the pointers would definitely meet the second time they over each others list.
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
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
      
      ListNode p1 = headA;
      ListNode p2 = headB;
      
      while(p1 != p2)
      {
    	//put the pointer to the head of other list  
        if(p1==null)
        {
          p1 = headB;
        }
        //move the pointer towards the end of the list
        else
        {
          p1 = p1.next;
        }
        
        //put the pointer to the head of other list 
        if(p2==null)
        {
          p2 = headA;
        }
        //move the pointer towards the end of the list
        else
        {
           p2 = p2.next;
        }
      }
      
      return p1;
    }
}