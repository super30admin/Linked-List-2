/**LC-160
 * Time Complexity : O(Max(M, N)) or O(M+N)... M and N are the lengths of the Linked list 
 * Space Complexity : O(1) 
 * Did this code successfully run on Leetcode : Yes
 * Any problem you faced while coding this : No
 *
 Algorithm:
 1. We find the lengths of both the linked lists.
 2. Since we need to find the intersectiom, we need to iterate at the same speed. In order to do so we need
    same lengths of both the lists.
 3. We take the diff of the two length, and the increment the pointer "diff" times of the longest list.
 4. Once we get a new head, we start iterating both the pointers by one until we get intersecting node

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
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        
        ListNode curr = headA;
        int lenA = 0;
        int lenB = 0;
        while(curr != null){
            
            lenA++;
            curr = curr.next;
        }
        
        curr = headB;
        while(curr != null){
            
            lenB++;
            curr = curr.next;
        }
        
        while(lenA < lenB){
            
            headB = headB.next;
            lenB--;
        }
        while(lenB < lenA){
            headA = headA.next;
            lenA--;
        }
        
        while(headA != headB){
            headA = headA.next;
            headB = headB.next;
        }
        
        return headA;   // we can also return headB
    }
}