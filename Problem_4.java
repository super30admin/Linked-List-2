// Time Complexity : O(m + n) where m and n are lengths of 2 linked lists
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach
/* We use 2 pointers p1 and p2 the get lengths of 2 lists. Then we get the difference of 2 lists. The longer list's 
   pointer is moved forward to cover the difference. Then we just move the 2 pointers one step each till we find the 
   intersection point.
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
        if(headA == null && headB == null)
            return null;

        int countA = 0;
        int countB = 0;
        ListNode p1 = headA;
        ListNode p2 = headB;

        while(p1 != null) {
            countA++;
            p1 = p1.next;
        }

        while(p2 != null) {
            countB++;
            p2 = p2.next;
        }

        p1 = headA;
        p2 = headB;

        if(countA > countB) {
            for(int i = 0; i < countA - countB; ++i) 
                p1 = p1.next;
            
            while(p1 != p2) {
                p1 = p1.next;
                p2 = p2.next;
            }
        } else {
            for(int i = 0; i < countB - countA; ++i) 
                p2 = p2.next;
            
            while(p1 != p2) {
                p1 = p1.next;
                p2 = p2.next;
            }
        }
        return p2;
    }
}