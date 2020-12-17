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
// Time complexity : O(N)
// Space COmplexity : O(1)
// 2 Pass solution.
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int length_1 = 0;
        int length_2 = 0;
        ListNode temp1 = headA;
        ListNode temp2 = headB;
        while(temp1 != null){
            length_1++;
            temp1 = temp1.next;
        }
        while(temp2 != null){
            length_2++;
            temp2 = temp2.next;
        }
        temp1 = length_1>length_2 ? headA : headB;
        temp2 = temp1 == headA ? headB : headA;
        int n = Math.abs(length_1-length_2);
        while(n!=0){
            temp1 = temp1.next;
            n--;
        }
        while(temp1 != temp2){
            temp1 = temp1.next;
            temp2 = temp2.next;
        }
        return temp1;
    }
}