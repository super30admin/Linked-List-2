public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lengthA = 0;
        int lengthB = 0;
        ListNode tempA = headA;
        ListNode tempB = headB;
        while(tempA != null) {
            lengthA += 1;
            tempA = tempA.next;
        }

        while(tempB != null) {
            lengthB += 1;
            tempB = tempB.next;
        }

        boolean isLengthABigger = false;
        int diff = 0;
        if(lengthA > lengthB) {
            isLengthABigger = true;
            diff = lengthA - lengthB;
        } else {
            diff = lengthB - lengthA;
        }

        tempA = headA;
        tempB = headB;
        while(diff > 0) {
            if(isLengthABigger) {
                tempA = tempA.next;
            } else {
                tempB = tempB.next;
            }
            diff -= 1;
        }

        while(tempA != null) {
            if(tempA == tempB) {
                return tempA;
            }
            tempA = tempA.next;
            tempB = tempB.next;
        }

        return null;
    }
}
