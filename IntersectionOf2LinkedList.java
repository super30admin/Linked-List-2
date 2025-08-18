// Time Complexity : O(m + n) — m = len(A), n = len(B)
// Space Complexity : O(1)
// Did this code successfully run on LeetCode : Yes

// approach:
// 1) Use two pointers currA and currB.
// 2) Advance each; when one hits null, switch it to the other list’s head.
// 3) They meet at the intersection or both become null (no intersection).


public class IntersectionOf2LinkedList {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode currA = headA, currB = headB;

        while(currA != currB){
            currA = currA.next;
            currB = currB.next;

            if(currA == null && currB == null) return null;

            if(currA == null){
                currA = headB;
            }

            if(currB == null){
                currB = headA;
            }
        }

        return currA;
    }
}
