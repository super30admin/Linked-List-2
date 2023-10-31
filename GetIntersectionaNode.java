// Time Complexity : O(M+N) where M & N are size of headA & headB respectively.
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public class GetIntersectionaNode {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        ListNode headADummy = headA;
        ListNode headBDummy = headB;

        while(headADummy != null && headBDummy != null )
        {
            headADummy = headADummy.next;
            headBDummy = headBDummy.next;
        }

        while(headADummy != null)
        {
            headADummy = headADummy.next;
            headA = headA.next;
        }

        while(headBDummy != null)
        {
            headBDummy = headBDummy.next;
            headB = headB.next;
        }

        while(headA != null && headB != null)
        {
            if(headA == headB)
                return headA;
            headA = headA.next;
            headB = headB.next;
        }

        return null;
    }
}
