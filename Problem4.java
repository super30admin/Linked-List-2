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

/**
 * Time complexity - O(n)
 * Space complexity - O(1)
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        int len1=0, len2=0;
        ListNode tempA = headA;
        while(tempA != null){
            len1++;
            tempA = tempA.next;
        }

        ListNode tempB = headB;
        while(tempB != null){
            len2++;
            tempB = tempB.next;
        }

        while(len1 > len2){
            headA = headA.next;
            len1--;
        }

        while(len2 > len1){
            headB = headB.next;
            len2--;
        }

        while(headA != headB){
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }
}