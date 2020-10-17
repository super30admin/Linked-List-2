/**
 * Write a program to find the node at which the intersection of two singly
 * linked lists begins.
 * 
 * Space Complexity: O(1) 
 * Time Complexity: O(n)
 * 
 * Number of Leetcode Attempts: 2
 * 
 * Leetcode Results: 
 * Runtime: 1 ms, faster than 98.84% of Java online submissions for Intersection of Two Linked Lists. 
 * Memory Usage: 38.7 MB, less than 47.86% of Java online submissions for Intersection of Two Linked Lists.
 */
public class IntersectionLL {
    /**
     * Idea is to have 2 cursor at both the heads, and seek forward cursor such that
     * now both cursors are equidistant from the tail. Now start incrementing them
     * until they meet or hit the tail.
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = length(headA), lenB = length(headB);
        ListNode cursorA = headA, cursorB = headB;
        if (lenA > lenB) {
            cursorA = seek(cursorA, lenA - lenB);
        } else {
            cursorB = seek(cursorB, lenB - lenA);
        }

        while (cursorA != null && cursorB != null) {
            if (cursorA == cursorB) {
                return cursorA;
            }
            cursorA = cursorA.next;
            cursorB = cursorB.next;
        }
        return null;
    }

    /**
     * helper to determine length of linkedlists
     */
    private int length(ListNode head) {
        int length = 0;
        while (head != null) {
            length++;
            head = head.next;
        }
        return length;
    }

    /**
     * 
     * @param cursor
     * @param steps
     * @return cursor seeked forward by `steps`
     */
    private ListNode seek(ListNode cursor, int steps) {
        while (steps > 0) {
            cursor = cursor.next;
            steps--;
        }
        return cursor;
    }
}