//o(m+n) time and o(1) space, m and n are length of linked list
//passed all leetcode cases
//used approach discussed in class
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
        int lena =0;
        int lenb=0;
        ListNode curr = headA;
        while(curr!= null){
            lena++;
            curr=curr.next;
        }
        curr=headB;
        while(curr!= null){
            lenb++;
            curr=curr.next;
        }
        while(lenb<lena){
            headA = headA.next;
            lena--;
        }
        while(lena<lenb){
            headB = headB.next;
            lenb--;
        }
        while(headA!=headB){
            headB = headB.next;
            headA = headA.next;
        }
        return headA;

    }
}