// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

/*
 * Approach:
 * In order to find the intersection node, we first find the lengths
 * of the 2 LLs and then move one of the pointers by the difference of
 * those lengths, then we move both pointers at 1x speed until the common node
 * is found.
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
import java.util.*;
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null && headB == null) {
            return null;
        }

        int lenA = 0, lenB = 0;

        // find lengths of the 2 lists
        ListNode ptr = headA;
        while(ptr != null) {
            lenA++;
            ptr = ptr.next;
        }
        ptr = headB;
        while(ptr != null) {
            lenB++;
            ptr = ptr.next;
        }

        // then move head of the larger list forward by diff
        if(lenA > lenB) {
            for(int i=0; i < lenA-lenB && headA != null; i++) {
                headA = headA.next;
            }
        } else if(lenA < lenB) {
            for(int i=0; i < lenB-lenA && headB != null; i++) {
                headB = headB.next;
            }
        }

        // then find common node
        while(headA != null && headB != null && headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }

        return headA;
    }
}