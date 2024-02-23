// Time Complexity : O(m+n),
// Space Complexity : O(1), using two pointers
// Did this code successfully run on Leetcode : yes
// Three line explanation of solution in plain english : Shrink the longer list to the same length as shorter one, and then traverse together while checking if they are equal.
// Your code here along with comments explaining your approach

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
        int lenA = 0;
        int lenB = 0;
        ListNode tempA = headA;
        ListNode tempB = headB;

        //find length of the lists
        while(tempA != null){
            lenA++;
            tempA= tempA.next;
        }

        while(tempB != null){
            lenB++;
            tempB= tempB.next;
        }

        //shrink the longer one the same length as short one
        while(lenA > lenB){
            headA = headA.next;
            lenA--;
        }

        while(lenA < lenB){
            headB = headB.next;
            lenB--;
        }

        while(headA != null){
            if(headA == headB){
                return headA;
            }

            headA = headA.next;
            headB = headB.next;
        }

        return null;
    }
}