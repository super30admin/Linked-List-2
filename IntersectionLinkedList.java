/**
Problem : Intersection of two linked lists
Did it run on LeetCode: Yes

Time Complexity : O(m + n), where m is the length of the first linked list and n is the length of the second linked list.
Space Complexity: O(1)

Approach:
1. Find the lengths of 2 lists A and B.
2. Then, whichever list's length is more, move its pointer by lenA minus lenB times.
3. From there, keep traversing the lists by moving both pointers by 1 and return the common node, when you find it.

*/

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
      
        int countA =0;
        int countB = 0;
        ListNode curr = headA;
        while(curr!=null) {
            curr = curr.next;
            countA++;
        }
        curr = headB;
        while(curr != null) {
            curr = curr.next;
            countB++;
        }
        while(countA > countB) {
            headA = headA.next;
            countA--;
        }
        while(countB > countA) {
            headB = headB.next;
            countB--;
        }
        while(headA!=headB) {
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }
}