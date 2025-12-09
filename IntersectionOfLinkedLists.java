// Approach 1

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
// Time: O(m + n)
// Space: O(1)
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = 0;
        ListNode curr = headA;
        
        // Find A length
        while (curr != null) {
            lenA ++;
            curr = curr.next;
        }

        // find B length
        curr = headB;
        int lenB = 0;
        while (curr != null) {
            lenB ++;
            curr = curr.next;
        }

        // Move the pointer of bigger list to match the length of the smaller list
        while (lenA > lenB) {
            headA = headA.next;
            lenA --;
        }
        while (lenB > lenA) {
            headB = headB.next;
            lenB --;
        }

        // move the pointer until both are not equal
        while (headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }

        // return the intersection node
        return headA;
    }
}

// Approach 2
// Time: O(m + n)
// Space: O(1)
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode currA = headA;
        ListNode currB = headB;

        while (currA != currB) {
            currA = currA.next;
            currB = currB.next;

            if (currA == null && currB == null) {
                // no intersection
                return null;
            }

            // Reached end of list, then start from the head of the other list
            if (currA == null) {
                currA = headB;
            }
            if (currB == null) {
                currB = headA;
            }
        }

        // return the meeting point / intersection node
        return currA;
    }
}