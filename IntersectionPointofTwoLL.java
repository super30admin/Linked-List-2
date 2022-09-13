// Time Complexity : O(m+n) m is the length of first LL and n if the length of second LL
// Space Complexity : O(m+n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach

public class IntersectionPointofTwoLL {
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

            ListNode curr = headA;
            while(curr != null){
                lenA++;
                curr = curr.next;
            }

            curr = headB;
            while(curr != null){
                lenB++;
                curr = curr.next;
            }

            while(lenA > lenB){
                headA = headA.next;
                lenA--;
            }

            while(lenB > lenA){
                headB = headB.next;
                lenB--;
            }

            while(headA != headB){
                headA= headA.next;
                headB =headB.next;
            }

            return headA;
        }
    }
}
