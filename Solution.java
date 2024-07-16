// Time Compelexity: O(n)
// Space Complexity: O(1)

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode currA = headA;
        ListNode currB = headB;

        while (currA != null && currB != null) {
            currA = currA.next;
            currB = currB.next;
        }

        int count = 0;

        while (currA != null) {
            currA = currA.next;
            count++;
        }

        while (currB != null) {
            currB = currB.next;
            count--;
        }

        currA = headA;
        currB = headB;

        if (count > 0) {
            while (count != 0) {
                currA = currA.next;
                count--;
            }
        }

        else {
            while (count != 0) {
                currB = currB.next;
                count++;
            }
        }

        while (currA != null && currB != null) {
            if (currA == currB)
                return currA;

            currA = currA.next;
            currB = currB.next;
        }

        return null;

    }
}