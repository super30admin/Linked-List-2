// Time Complexity :O(n+m)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        
        ListNode nodesA = headA;
        ListNode nodesB = headB;
        
        while(nodesA != nodesB){
            if(nodesA == null){
                nodesA = headB;
            }else{
                nodesA = nodesA.next;
            }
             if(nodesB == null){
                nodesB = headA;
            }else{
                nodesB = nodesB.next;
            }
        }
        
        return nodesA;
    }
}
