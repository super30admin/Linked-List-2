// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


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

        int lengthA = 0;
        int lengthB = 0;
        ListNode curr = headA;

        while(curr!=null) {
            curr = curr.next;
            lengthA++;
        }

        curr = headB;

        while(curr!=null) {
            curr = curr.next;
            lengthB++;
        }

        ListNode p1 = headA;
        ListNode p2 = headB;

        while(lengthA > lengthB) {
            p1 = p1.next;
            lengthA--;
        }

        while(lengthB > lengthA) {
            p2 = p2.next;
            lengthB--;
        }

        while(p1 != p2){
            p1 = p1.next;
            p2 = p2.next;
        }

        return p1;

    }
}