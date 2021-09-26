// Time Complexity : O(m + n)
// Space Complexity : O(m + n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

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
public class IntersectionOfTwoLinkedList {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        
        ListNode curr = headA;
        int lenA = 0;
        while(curr != null) {
            curr = curr.next;
            lenA++;
        } //found the length of A
        
        curr = headB;
        int lenB = 0;
        while(curr != null) {
            curr = curr.next;
            lenB++;
        } //found the length of B
        
        while(lenA > lenB) { //if A is bigger than B
            headA = headA.next; //moving head by places equal to the diff of lengths
            lenA--;
        }
        
        while(lenB > lenA) { //if B is bigger than A
            headB = headB.next; //moving head
            lenB--;
        }
        
        //at this stage, both heads are at same distance from meeting point
        //now all we need to do is move both of them ahead till they meet
        
        while(headA != headB) {
            headA = headA.next;
            headB = headB.next;
        } //they will meet now at the same distance
        
        //either return headA or headB, both are at same pointer
        return headA; //OR return headB;
    }
}