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
 
 Time complexity O(n)
 space complexity O(1)
 */

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA=0;
        int lenB=0;
        if(headA==null || headB==null) return null;
        ListNode A=headA;ListNode B=headB;
        while(A.next!=null){
            lenA++;
            A=A.next;
        }
        while(B.next!=null){
            lenB++;
            B=B.next;
        }
        while(lenA>lenB){
            headA=headA.next;
            lenA--;
        }
        while(lenB>lenA){
            headB=headB.next;
            lenB--;
        }
        while(headA!=headB){
            headA=headA.next;
            headB=headB.next;
            
        }
        return headA;
    }
}
