//Time Complexity: O(N)
//Space Complexity: O(1)

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
        int l2=0;
        ListNode curr=headA;
        while(curr!=null){
            curr=curr.next;
            l1++;
        }
        curr=headB;
        while(curr!=null){
            curr=curr.next;
            l2++;
        }
        while(l1>l2){
            headA=headA.next;
            l1--;
        }
        while(l2>l1){
            headB=headB.next;
            l2--;
        }
        while(headA!=headB){
            headA=headA.next;
            headB=headB.next;
        }
        return headA;
    }
}
