// Time Complexity : O(m+n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Three line explanation of solution in plain english: I used the same logic Jaspinder explained. 

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
        int l1=0;
        ListNode cur = headA;
        while(cur != null){
            cur = cur.next;
            l1++;
        }

        int l2=0;
        cur = headB;
        while(cur != null){
            cur = cur.next;
            l2++;
        }

        while(l1 < l2){
            headB = headB.next;
            l2--;
        }

        while(l2 < l1){
            headA = headA.next;
            l1--;
        }

        while( headA != headB){
            headA = headA.next;
            headB = headB.next;
        }

        return headA;
    }
}