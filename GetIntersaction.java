// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

1. find length of both the linked list
2. set count = biglength - small length
3. bring the start pointers of both the list at same index 
4. now start moving in both the linked list until listAponiet == listBpointer

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
        
        int countA = 0;
         ListNode dummyA =   headA;
          ListNode dummyB =   headB;
        
        if(headA == headB)
        {
            return headA;
        }
        while(dummyA != null)
        {
            countA++;
            dummyA = dummyA.next;
        }
        
        int countB = 0;
        while(dummyB != null)
        {
            countB++;
            dummyB = dummyB.next;
        }
        int headAindex = 0;
        if(countA > countB)
        {
            int count = countA - countB;
                while(count>0)
                {
                    count--;
                    headA=headA.next;
                }
        }
        else if(countB > countA)
        {
            
            int count = countB - countA;
                while(count >0)
                {
                    count--;
                    headB=headB.next;
                }
        }
        
        while(headA != null  || headB != null)
        {
            if(headA == headB)
            {
                return headA;
            }
             headB = headB.next;
             headA = headA.next;
        }
        
        
         return null;   
    }
}