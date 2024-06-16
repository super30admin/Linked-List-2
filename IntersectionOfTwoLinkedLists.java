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

// Time Complexity : O(m + n) => where m is the number of nodes in listA & n is the number of nodes in listB
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/*
Approach: First calculate length of both the list. Then the list which has more start travesing from that list until it reaches the start point of the other list. Then start comparing the nodes to check if they are equal.
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        if(headA == null || headB == null){
            return null;
        }

        ListNode listA = headA;
        ListNode listB = headB;
        int lenA = 0;
        int lenB = 0;

        //Count the no. of nodes in List A
        while(listA != null){
            lenA = lenA + 1;
            listA = listA.next;
        }

        //Count no. of nodes in List B
        while(listB != null){
            lenB = lenB + 1;
            listB = listB.next;
        }

        listA = headA;
        listB = headB;

        //Move forward to make sure both the pointers have equal distance to cover
        while(lenA > lenB){
            lenA = lenA - 1;
            listA = listA.next;
        }

        while(lenA < lenB){
            lenB = lenB - 1;
            listB = listB.next;
        }

        //At this point, both the pointers have equal distance to cover
        while(listA != null){
            //Need to check referennces and not the value
            if(listA == listB){
                return listA;
            }

            listA = listA.next;
            listB = listB.next;
        }

        return null;

    }
}