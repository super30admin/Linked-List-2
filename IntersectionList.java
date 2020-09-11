// Time Complexity :O (n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
/*
Maintain two pointers pa and pb initialized at the head of A and B, 
When pa reaches the end of a list, then redirect it to the head of B 
If at any point pa meets pb, then it is the intersection node.
*/
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode pa = headA;
        ListNode pb = headB;
        
        while(pa != pb){ 
            pa = pa != null ? pa.next : headB;
            pb = pb != null ? pb.next : headA; 
        } 
       return pa; 
    }
}