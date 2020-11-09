// Time Complexity : O(m+n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :nopes


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
public class Intersection {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        ListNode current=headA;

        int lenA=0;
        int lenB=0;

        while(current!=null)
        {
            current=current.next;
            lenA++;
        }

        current=headB;

        while(current!=null)
        {
            current=current.next;
            lenB++;
        }

        while(lenA<lenB)
        {
            headB=headB.next;
            lenB--;
        }

        while(lenB<lenA)
        {
            headA=headA.next;
            lenA--;
        }

        while(headA!=headB)
        {
            headA=headA.next;
            headB=headB.next;
        }

        return headA;
    }
}