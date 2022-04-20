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
public class IntersectionNode {

    // Time Complexity : 0(m+n) where m is the length of 1st list and n is the length of 2nd list
// Space Complexity : 0(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach: First I am finding the length of both the lists. Then I am
    //advancing my head of the lower sized list till it equals the length of larger list. Then I am returning the point when
    //mu head of a and head of b meet if they do.

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int countA = 0;
        int countB = 0;
        ListNode a = headA;
        ListNode b = headB;
        while(a != null){
            countA++;
            a= a.next;
        }
        while(b != null){
            countB++;
            b = b.next;
        }
        while(countA > countB){
            countA--;
            headA = headA.next;
        }
        while(countB > countA){
            countB--;
            headB = headB.next;
        }
        while(headA != headB){
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }
}