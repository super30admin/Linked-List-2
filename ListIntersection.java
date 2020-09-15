// Time Complexity :O(N)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
//1. Keep track of the dummy pointers at each list and move them until they have the same length.
//2.Returning the node that would have the same point would give the point of intersection

public class ListIntersection {
    static class ListNode {
        int data;
        ListNode next;

        ListNode(int ele) {
            data = ele;
        }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = 0, lenB = 0;
        ListNode dummyA = headA;
        ListNode dummyB = headB;
        // Find length of lists
        while (dummyA != null) {
            lenA++;
            dummyA = dummyA.next;
        }

        while (dummyB != null) {
            lenB++;
            dummyB = dummyB.next;
        }

        dummyA = headA;
        dummyB = headB;
        if (lenA > lenB) {
            while (lenA != lenB) {
                lenA--;
                dummyA = dummyA.next;
            }
        } else {
            while (lenA != lenB) {
                lenB--;
                dummyB = dummyB.next;
            }
        }

        //
        while (dummyA != null && dummyB != null) {
            if (dummyA == dummyB)
                return dummyA;
            dummyA = dummyA.next;
            dummyB = dummyB.next;
        }
        return null;
    }

    public static void main(String args[]) {
        System.out.println("intersection of two lists");
    }
}
