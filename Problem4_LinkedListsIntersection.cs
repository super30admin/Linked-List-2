// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     public int val;
 *     public ListNode next;
 *     public ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode GetIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) return null;

        int headACount = 0;
        int headBCount = 0;
        ListNode temp = headA;
        while(temp != null) { //Count the nodes in headA list
            temp = temp.next;
            headACount++;
        }
        temp = headB;
        while(temp != null) { //Count the nodes in headB list
            temp = temp.next;
            headBCount++;
        }
        while(headACount != headBCount) { // If the length of two lists is not equal
            if(headACount > headBCount) { // If headA list length is greater than headB
                //Move headA by 1 node until the length the 2 lists are equal
                headA = headA.next;
                headACount--;
            }
            else { //If headB list length is greater than headB
                //Move headB
                headB = headB.next;
                headBCount--;
            }
        }
        //Now headA and headB lengths are equal
        while(headA != null || headB != null) {
            //Traverse through both lists to find intersecting node
            if(headA == headB) {
                return headA;
            }
            headA = headA.next;
            headB = headB.next;
        }
        return null;
    }
}