// Time Complexity : O(m+n). m and n are lengths of two nodes
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Approach : We first find the lengths of two linkedlists and move pointer on the one that has greater length. We traverse in both linkedlists using two pointers
// and compare values, if equal that is the intersection point.


public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode pointerA = headA;
        ListNode pointerB = headB;
        int lengthA = 0;
        int lengthB = 0;
        while(headA != null){ //finding length
            headA = headA.next;
            lengthA++;
        }
        while(headB != null){ //finding length
            headB = headB.next;
            lengthB++;
        }

        if(lengthA > lengthB){ //if length of A is greater
            int diff = lengthA - lengthB;
            int count = 0;
            while(count != diff){
                pointerA = pointerA.next; //move pointer A until difference value
                count++;
            }
        }

        if(lengthA < lengthB){ //if length of B is greater
            int diff = lengthB - lengthA;
            int count = 0;
            while(count != diff){
                pointerB = pointerB.next; //move pointer B until difference value
                count++;
            }
        }

        while(pointerA != null){ //move both pointer
            if(pointerA == pointerB){ //intersection point
                return pointerA; //return intersection
            }
            pointerA = pointerA.next;
            pointerB = pointerB.next;

        }
        return null;
    }
}