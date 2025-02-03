// In this problem, we are keeping two pointers at the head of each LL. Now, the lengths of the two LL can be different. So, first move 
// the pointer of LL which has greater length, and move till both length are equal. Now move both and check if values equal, that means
// that is the node of intersection, else it will reach end where both will be null and it will return null in case of no intersection.

// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

public class IntersectionLL {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // Base case - If any of one LL is null, that means no intersection, so null
        if (headA == null || headB == null) {
            return null;
        }
        // Two pointers at head of each node
        ListNode currA = headA;
        ListNode currB = headB;
        int lenA = 0;
        int lenB = 0;
        // Calculate length of both LL first
        while (currA != null) {
            lenA++;
            currA = currA.next;
        }
        while (currB != null) {
            lenB++;
            currB = currB.next;
        }
        // Reset the pointers to head again
        currA = headA;
        currB = headB;
        // Now check which length is greater
        if (lenA > lenB) {
            // Accordingly move that pointer till length are equal
            while (lenA != lenB) {
                lenA--;
                currA = currA.next;
            }
        } else if (lenB > lenA) {
            while (lenA != lenB) {
                lenB--;
                currB = currB.next;
            }
        }
        // Now after both len are equal, move both pointer
        while (currA != currB) {
            currA = currA.next;
            currB = currB.next;
        }
        // If no intersection then both will be equal when reach end i.e. null
        // Return either of them
        return currA;
    }
}