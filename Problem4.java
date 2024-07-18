//Time = O(m+n), where m and n are the lengths of the input linked lists
//Space = O(1)

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
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // If either list is null, there can be no intersection
        if (headA == null || headB == null) {
            return null;
        }
        
        // Find the lengths of both lists
        int lengthA = getListLength(headA);
        int lengthB = getListLength(headB);
        
        // Move the longer list's pointer to the same starting point as the shorter list's pointer
        if (lengthA > lengthB) {
            headA = movePointer(headA, lengthA - lengthB);
        } else if (lengthB > lengthA) {
            headB = movePointer(headB, lengthB - lengthA);
        }
        
        // Traverse both lists in tandem until an intersection is found
        while (headA != null && headB != null) {
            if (headA == headB) {
                return headA;
            }
            headA = headA.next;
            headB = headB.next;
        }
        
        // If there is no intersection, return null
        return null;
    }
    
    // Helper method to find the length of a linked list
    private int getListLength(ListNode head) {
        int length = 0;
        while (head != null) {
            length++;
            head = head.next;
        }
        return length;
    }
    
    // Helper method to move a linked list pointer a certain number of nodes
    private ListNode movePointer(ListNode head, int count) {
        for (int i = 0; i < count; i++) {
            head = head.next;
        }
        return head;
    }
}
