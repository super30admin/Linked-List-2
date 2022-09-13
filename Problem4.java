// Time Complexity : O(N+ N)= O(N)
// Space Complexity : 0(1)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO


// Your code here along with comments explaining your approach
/**
 * For this intersection problem, we will make the length of both lists equal and then find the intersecting point.
 * We will move the head of smaller lists , so that both are of same size. Then we will traverse until we find the meeting point
 * of both heads.
 */

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
public class Problem4 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        //will calculate length of both the lists
        int lenA =0;
        int lenB = 0;
        ListNode curr = headA;
        ListNode curr2 = headB;

        while(curr!=null){

            lenA++;
            curr = curr.next;
        }

        while(curr2!=null){

            lenB++;
            curr2 = curr2.next;
        }

        //move the head of smaller list
        //decrease the length of greater list
        while(lenA>lenB){

            headA = headA.next;
            lenA--;

        }
        while(lenB>lenA){

            headB = headB.next;
            lenB--;
        }

        //now both the lists are equal
        while(headA!= headB){

            headA= headA.next;
            headB = headB.next;
        }

        return headA;

    }
}