// Time Complexity :O(N)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :Nope.


// Your code here along with comments explaining your approach

public class IntersectionOfTwoLinkedLists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(null == headA || null == headB){return null;}
        if(headA == headB){return headA;}
        ListNode nodeA = headA, nodeB = headB;
        while(nodeA != nodeB){
            nodeA = (null==nodeA)?headB:nodeA.next;
            nodeB = (null==nodeB)?headA:nodeB.next;
        }
    return nodeA;
    }
}