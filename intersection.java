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
// time; O(n)
// space; o(1)
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA==null && headB==null) return headA;
        int lenA=0;
        int lenB=0;
        ListNode node=headA;
        while(node!=null)
        {
            lenA++;
            node=node.next;
        }
        node=headB;
        while(node!=null)
        {
            lenB++;
            node=node.next;
        }
        // To check which one is greater
        if(lenA>lenB)
        {
            while(lenA!=lenB)
            {
                lenA--;
                headA=headA.next;
            }
        }
        else{
            while(lenA!=lenB)
            {
                lenB--;
                headB=headB.next;
            }
        }
        // checking for intersection
        while(headA!=null)
        {
            if(headA==headB) return headA;
            headA=headA.next;
            headB=headB.next;
        }
        return null;
        
    }
}