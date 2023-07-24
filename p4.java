// Time Complexity : O(m+n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


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
        //Variables to get the length of the lists
        int la = 0;
        int lb = 0;

        ListNode a = headA;
        ListNode b = headB;
//Loop to get the lengths
        while(a!=null){
            la++;
            a=a.next;
        }

        while(b!=null){
            lb++;
            b=b.next;
        }
//Loop to ensure both the pointers are equidistant from the intersecting node
        a = headA;
        b = headB;

        while(la>lb){
            a=a.next;
            la--;
        }

        while(lb>la){
            b=b.next;
            lb--;
        }
//Loop to find the intersecting node
        while(a!=b){
            a = a.next;
            b=b.next;
        }

        return a;
        
    }
}