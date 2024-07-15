// Time Complexity : O(N+M);
// Space Complexity :O(1);
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

public class intersection {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // Calculate the length of list A
        int lengthA = 0;
        ListNode pA = headA;
        while (pA != null) {
            lengthA++;
            pA = pA.next;
        }
        
        // Calculate the length of list B
        int lengthB = 0;
        ListNode pB = headB;
        while (pB != null) {
            lengthB++;
            pB = pB.next;
        }

        // Reset pointers to the original heads
        pA = headA;
        pB = headB;
        
        // Adjust the longer list's pointer so they start at the same relative position
        while (lengthA > lengthB) {
            pA = pA.next;
            lengthA--;
        }
        while (lengthB > lengthA) {
            pB = pB.next;
            lengthB--;
        }

        // Traverse both lists until intersection or end is found
        while (pA != null) {
            if (pA == pB) // Intersection found
                break;
            pA = pA.next;
            pB = pB.next;
        }
        
        // Return the intersection node (or null if no intersection)
        return pA;
    }
}
