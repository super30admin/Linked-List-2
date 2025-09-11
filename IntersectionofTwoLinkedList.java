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
// Time Complexity : O(m+n) -> iterating through both the list 
// Space Complexity : O(1) -> no additional space used
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/*
* Count the length of list A and list B
* Move the head of the bigger list where the length of both the list becomes the same
* Keep iterating until the matching node is found
*/
public class IntersectionofTwoLinkedList {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int counterA = 0;
        ListNode headACopy = headA;
        while(headACopy != null){
            counterA++;
            headACopy = headACopy.next;
        }

        int counterB = 0;
        ListNode headBCopy = headB;
        while(headBCopy != null){
            counterB++;
            headBCopy = headBCopy.next;
        }

        headACopy = headA;
        while(counterA > counterB){
            headACopy = headACopy.next;
            counterA --;
        }

        headBCopy = headB;
        while(counterB > counterA){
            headBCopy = headBCopy.next;
            counterB --;
        }

        while(headACopy != headBCopy){
            headACopy = headACopy.next;
            headBCopy = headBCopy.next;
        }
        return headACopy;
    }
}