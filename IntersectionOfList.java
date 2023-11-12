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
 
 - calculate the length of list A and B
 - whichever is greater, traverse that many node in the first list
 - then keep incrementing till both intersect 
 - return the intersected node
 - TC: O(n)
 - SC: O(1)

 */


public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA= 0;
        int lenB=0;
        ListNode curr = headA;

        while(curr!=null)
        {
            lenA++;
            curr=curr.next;
        }

        curr = headB;
        while(curr!=null)
        {
            lenB++;
            curr=curr.next;
        }

        ListNode headofA = headA;
        ListNode headofB = headB;
        if(lenA > lenB)
        {
            int n =lenA - lenB;
            while(n!=0)
            {
                headofA = headofA.next;
                n--;
            }
        }

        if(lenB > lenA)
        {
            int n =lenB - lenA;
            while(n!=0)
            {
                headofB = headofB.next;
                n--;
            }
        }


        while(headofA!=headofB)
        {
            headofA = headofA.next;
            headofB = headofB.next;
        }

        return headofA;
    }
}