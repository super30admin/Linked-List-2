//https://leetcode.com/problems/intersection-of-two-linked-lists/
/*
Time: O(m+n) where m is List1 size and n is the List2 size
Space: O(1)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : None
*/
public class ListIntersection {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        if (headA == null || headB == null)
            return null;

        ListNode tempA = headA;
        ListNode tempB = headB;

        while (tempA != tempB) {
            tempA = (tempA != null) ? tempA.next : headB; // either move to 'next' or to 'the head of other list'
            tempB = (tempB != null) ? tempB.next : headA;
        }

        return tempA;
    }

}
