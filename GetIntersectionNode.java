// Time Complexity : O(m + n) == O(Max(m, n))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
Find the length of both the lists. Find the difference between both the lengths. If first list is longer than second, then move headA diff times and vice versa.
Once both headA and headB are at same distance from intersection, start iterating the both lists together, if they both reach same node at same time then stop and return node.
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

        //Find the length of both the list
        ListNode p1 = headA;
        int lenA = 0;

        while(p1 != null) {
            p1 = p1.next;
            lenA++;
        }

        ListNode p2 = headB;
        int lenB = 0;

        while(p2 != null) {
            p2 = p2.next;
            lenB++;
        }

        //If lenA > lenB, increment p1 until both p1,p2 are at same distance from intersection and vice versa
        while(lenA > lenB) {
            headA = headA.next;
            lenA--;
        }

        while(lenB > lenA) {
            headB = headB.next;
            lenB--;
        }

        //Both the pointers are at same distance from intersection.
        //Hence they will meet at same point
        while(headA != headB) {

            headA = headA.next;
            headB = headB.next;
        }
        
        return headA;
    }
}