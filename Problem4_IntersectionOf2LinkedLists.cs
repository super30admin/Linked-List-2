// Approach : find the lengths of both the lists. Iterate through the longer list(say length m) until you are left n nodes(second list length) to reach end of longer list. Now traverse through both the list parallely until you reach the intersection point.
// Time Complexity : O(m+n) worst case when the lists dont meet we go through all the all the elements in both lists twice, Once to find the lengths and again to find the intersection point.
// Space Complexity : O(1)

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     public int val;
 *     public ListNode next;
 *     public ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode GetIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = FindLength(headA);
        int lenB = FindLength(headB);
        
        if(lenB > lenA) return GetIntersectionNode(headB, headA);
        
        int diff = lenA - lenB;
        
        ListNode pA = headA, pB = headB;
        
        while(diff != 0){
            pA = pA.next;
            diff--; 
        }
        
        while(pA != pB)
        {
            pA = pA.next;
            pB = pB.next;
        }
        
        return pA;
    }
    
    public int FindLength(ListNode head){
        int len = 0;
        ListNode l = head;
        while(l != null){
            len++;
            l = l.next;
        }
        
        return len;
    }
}