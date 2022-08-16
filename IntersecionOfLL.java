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
        
        int lenA=0;
        
        ListNode node = headA;
        while(node!=null){
            lenA++;
            node = node.next;
        }
        
        int lenB=0;
        
        node = headB;
        while(node!=null){
            lenB++;
            node = node.next;
        }
        
        while(lenA > lenB){
            headA = headA.next;
            lenA--;
        }
        
        while(lenB > lenA){
            headB = headB.next;
            lenB--;
        }
        
        while(headA != null){
            if(headA == headB)
                return headA;
            headA=headA.next;
            headB=headB.next;
        }
        return null;
    }
}
