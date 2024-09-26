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

/*
Time Complexity : O(m + n)
Space Complexity : O(1)
Accepted on Leetcode : Yes

Approach: We calculate the size of both linked list and increase head pointer of the list which has larger size such that the new pointer position corressponds to lists of equal length
*/
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) { 

        if(headA == null || headB == null)
            return null;

        int lenA = 0;
        int lenB = 0;

        ListNode temp = headA;

        while(temp != null){
            lenA = lenA + 1;
            temp = temp.next;
        }

        temp = headB;

        while(temp != null){
            lenB = lenB + 1;
            temp = temp.next;
        }
//depending upon which length is greater, increment the head of the larger list
        if(lenA > lenB){
            while(lenA > lenB){
                headA = headA.next;
                lenA = lenA - 1;
            }
        }
        else{
                while(lenB > lenA){
                    headB = headB.next;
                    lenB = lenB - 1;
                }
            }

        while(lenA > 0 && lenB > 0){
            if(headA.equals(headB))
                return headA;

            headA = headA.next;
            headB = headB.next;
            lenA = lenA - 1;
            lenB = lenB - 1;

        }
        return null;
    }
}