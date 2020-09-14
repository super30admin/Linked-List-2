// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach

// hashset soln
// Time Complexity : O(Max(len(headA),len(headB)))
// Space Complexity : O( len(headA)+len(headB)) , when no intersection
// add all the listnode from either headA (or headB) to the hashset and then,
//  check if any node from headB(or headA) is already present in the hash set
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null)
            return headA;
        if (headB == null)
            return headB;

        HashSet<ListNode> hs = new HashSet<>();
        while (headA != null) {
            hs.add(headA);
            headA = headA.next;
        }
        while (headB != null) {
            if (hs.contains(headB))
                return headB;
            headB = headB.next;
        }

        return null;
    }
}

// optimal solution
// inorder to find the point of intersection, we need headA == headB.. but this
// can be only possible if
// sizeA =sizeB so we try to move the ptr(sizebig-sizesmall) times in the
// headbig so that both are equidistant from the intersection point.

// if we reach the end and there is no intersection we return null

// Time Complexity : O(n) where n is the size of both the lists( we got through
// both list and then max(lenA,lenB)(while comparing) )
// Space Complexity : O(1) since no constant space is required

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        int sizeA = 0, sizeB = 0;
        ListNode dummy_A = headA;
        ListNode dummy_B = headB;
        while (dummy_A != null) {
            sizeA++;
            dummy_A = dummy_A.next;
        }

        while (dummy_B != null) {
            sizeB++;
            dummy_B = dummy_B.next;
        }

        dummy_A = headA;
        dummy_B = headB;

        if (sizeA > sizeB) {
            for (int i = 0; i < sizeA - sizeB; i++) {
                dummy_A = dummy_A.next;
            }
        } else {
            for (int i = 0; i < sizeB - sizeA; i++) {
                dummy_B = dummy_B.next;
            }
        }

        while (dummy_A != null && dummy_B != null) {
            if (dummy_A == dummy_B) {
                return dummy_B;
            }
            dummy_A = dummy_A.next;
            dummy_B = dummy_B.next;
        }

        return null;
    }
}