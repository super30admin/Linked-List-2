// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Your code here along with comments explaining your approach

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        
        
        ListNode nodeA = headA;
        ListNode nodeB = headB;
        
        while(nodeA != nodeB) {            
            if(nodeA != null){
                nodeA = nodeA.next;
            }
            else{
                nodeA = headB;
            
            if(nodeB != null){
                nodeB = nodeB.next;
            }
            else{
                nodeB = headA;
            }            
        }
        
        return nodeA;
    }
}
