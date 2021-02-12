// Time Complexity :O(2*n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No


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
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA==null || headB==null)
            return null;
        ListNode p1=headA;
        ListNode p2= headB;
        
        while(p1!=p2)//return when both pointers reach same value
        {
          
            if(p1==null){
                p1=headB;//if we reach end of one list we start again, but with second list's head
            }
            else
                p1=p1.next;
            if(p2==null)
                p2=headA;//if we reach the end start with other list's head
            else
            {
                p2=p2.next;
            }
        }//In the end if both list's have a common node, both pointer will reach there else they both will point to null after some time.
        
        return p1;
        
    }
}