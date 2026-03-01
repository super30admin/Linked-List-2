// Time Complexity : O(m + n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach
/*
Compute the sizes of both the linked lists by using count variables.The idea is to move the pointer by m - n times
 of that list whose size is greater(if m > n). Else, n-m times(if n> m).This way, we can now start moving
 the heads of both the linked lists one step at a time until they intersect. Even if non intersecting,
 we return null in that case.
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
        int countA = 0, countB = 0;
        ListNode currA = headA;
        ListNode currB = headB;

        while(currA != null) {
            currA = currA.next;
            countA++;
        }

        while(currB != null) {
            currB = currB.next;
            countB++;
        }

        currA = headA;
        currB = headB;
        while(countA > countB) {
            currA = currA.next;
            countA--;
        }

        while(countB > countA) {
            currB = currB.next;
            countB--;
        }

        while(currA != currB) {
            currA = currA.next;
            currB = currB.next;
        }
        return currA;
    }
}