// Time Complexity : O(n + m), n is len of A and m is len of B
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

public class twoLLIntersect {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode nodeA = headA;
        ListNode nodeB = headB;
        
        while(nodeA != nodeB) {
            if(nodeA == null)
                nodeA = headB;
            else
                nodeA = nodeA.next;
            if(nodeB == null)
                nodeB = headA;
            else
                nodeB = nodeB.next;
        }
        return nodeB;
    }
    
}
