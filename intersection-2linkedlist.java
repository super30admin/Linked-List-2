/**
 * Time: O(max(m,n)) m,n are the length of the lists passed
 * Space:O(1)
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
        int len1=0, len2 =0;
        ListNode temp = headA;
        while(temp != null){
            temp = temp.next;
            len1++;
        }
        temp = headB;
        while(temp != null){
            temp = temp.next;
            len2++;
        }
        if(len1 > len2){
            int idx = len1-len2;
            while(idx!=0){
                headA = headA.next;
                idx--;
            }
        }else if(len2 > len1){
            int idx = len2 - len1;
            while(idx != 0){
                headB = headB.next;
                idx--;
            }
        }

        while(headA!=null){
            if(headA == headB)
                return headA;
            headA = headA.next;
            headB = headB.next;
        }
        return null;
    }
}