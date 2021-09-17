// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = 0;
        int lenB = 0;
        ListNode current = headA;

        // find length of first linked list
        while(current != null){
            current = current.next;
            lenA++;
        }

        // find length of second linked list
        current = headB;
        while(current != null){
            current = current.next;
            lenB++;
        }

        // keep moving the pointer in the longer linked list
        // so that remaining elements to traverse of both linked list are equal
        while(lenA > lenB){
            headA = headA.next;
            lenA--;
        }
        while(lenB > lenA){
            headB = headB.next;
            lenB--;
        }

        // keep traversing until same node is found on both the linked lists
        while(headA != headB){
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }
}