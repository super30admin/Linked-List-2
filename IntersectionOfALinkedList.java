// Time Complexity : O(m+n)
// Space Complexity : O(m)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

import java.util.HashSet;

public class IntersectionOfALinkedList {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null && headB == null){
            return headA;
        }

        if(headA == null || headB == null){
            return null;
        }

        HashSet<ListNode> set = new HashSet<>();
        ListNode A = headA;
        while(A != null){
            set.add(A);
            A = A.next;
        }
        ListNode B = headB;
        while(B != null){
            if(set.contains(B)){
                return B;
            }
            B = B.next;
        }

        return null;
    }
}
