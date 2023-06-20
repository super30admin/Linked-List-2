// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : no issues


// Your code here along with comments explaining your approach:
// Find out the lengths of 2 linked lists . then move the longer linked list pointer by the diff b/w 2 lengths.
// So that they are equal distance from the intersection point.
// now move the both pointer till either one of them is null. and check if both meet at same treenode


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
        ListNode Apointer=headA;
        ListNode Bpointer=headB;
        int Acount=0;
        int Bcount=0;

        while(Apointer!=null)
        {
            Acount++;
            Apointer=Apointer.next;
        }
        while(Bpointer!=null)
        {
            Bcount++;
            Bpointer=Bpointer.next;
        }

        // System.out.println(Acount);
        // System.out.println(Bcount);
        Apointer=headA;
        Bpointer=headB;
        while(Bcount>Acount){
            Bpointer=Bpointer.next;
            Bcount--;
        }
        while(Acount>Bcount){
            Apointer=Apointer.next;
            Acount--;
        }
        while(Apointer!=Bpointer){
            Apointer=Apointer.next;
            Bpointer=Bpointer.next;
        }
        return Apointer;
    }
}