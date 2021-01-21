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
        int lenA = 0, lenB = 0;
        ListNode curr = headA;
        while(curr != null){
            curr = curr.next;
            lenA++;
        }
        curr = headB;
        while(curr != null){
            curr = curr.next;
            lenB++;
        }
        while(lenA>lenB){
            headA = headA.next;
            lenA--;
        }
        
        while(lenB > lenA) {
            headB = headB.next;
            lenB--;
        }
        
        while(headA != headB){
            headA = headA.next;
            headB = headB.next;
        }
        
        return headB;
        
    }
}


/*

Brute force is to store nodes in hashmap since its by reference. 
Otherwise, we can have pointers? 
But this uses extra space.
Can also use two pointers: find length of both lists, take difference and move the pointers accordingly. O(m+n) time complexity, no extra space. 




*/