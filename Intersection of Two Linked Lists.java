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

// Time Complexity = O(M+N)
// Space Complexit = O(1)

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int len1 = 0;
        int len2 = 0;
        ListNode temp1 = headA;
        ListNode temp2 = headB;
        while(temp1 != null){
            temp1 =temp1.next;
            len1++;
        }
        while(temp2 != null){
            temp2 =temp2.next;
            len2++;
        }    
        
        // listA is longer
        if(len1 > len2){
            int diff = len1 - len2;
            while(diff > 0){
                headA = headA.next;
                diff--;
            }
        }
        if(len2 > len1){
            int diff = len2 - len1;
            while(diff > 0){
                headB = headB.next;
                diff--;
            }
        }
        
        while(headA != headB){
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }
}