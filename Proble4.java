/*
Time Complexity -> O(N)
Space Complexity -> O(N)
*/

class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null) {
            return headA;
        }
        if (headB == null) {
            return headB;
        }
        HashSet hashSet = new HashSet<>();
        ListNode tempA = headA;
        while (tempA != null) {
            hashSet.add(tempA);
            tempA = tempA.next;
        }
        ListNode tempB = headB;
        while (tempB != null) {
            if (hashSet.contains(tempB)) {
                return tempB;
            }
            tempB = tempB.next;
        }
        return null;
    }
}

/*
Time Complexity -> O(N)
Space Complexity -> O(1)
*/


class Solution1 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null) {
            return headA;
        }
        if (headB == null) {
            return headB;
        }
        int lenA = 0;
        ListNode tempA = headA;
        while (tempA != null) {
            lenA++;
            tempA = tempA.next;
        }
        int lenB = 0;
        ListNode tempB = headB;
        while (tempB != null) {
            lenB++;
            tempB = tempB.next;
        }
        tempA = headA;
        tempB = headB;
        while (lenA > lenB) {
            tempA = tempA.next;
            lenA--;
        }
        while (lenB > lenA) {
            tempB = tempB.next;
            lenB--;
        }
        while (tempA != tempB) {
            tempA = tempA.next;
            tempB = tempB.next;
        }

        return tempA;
    }
}