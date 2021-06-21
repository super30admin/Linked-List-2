// Time Complexity: O(n) where n is the length of the longer linked list
// Space Complexity: O(1)

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
        int sizeA = 0;
        int sizeB = 0;
        
        ListNode currA = headA;
        while(currA != null){
            sizeA++;
            currA = currA.next;
        }
        
        ListNode currB = headB;
        while(currB != null){
            sizeB++;
            currB = currB.next;
        }
        while(sizeA > sizeB){
            headA = headA.next;
            sizeA--;
        }
        while(sizeB > sizeA){
            headB = headB.next;
            sizeB--;
        }
        
        while(headA != headB){
            headA = headA.next;
            headB = headB.next;
        }
        
        return headA;
    }
}