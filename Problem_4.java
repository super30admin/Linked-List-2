// Time Complexity :O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        
        ListNode curr = headA;
        int lenA=0;
        
        while(curr != null){
            curr = curr.next;
            lenA++;
        }
        
        curr = headB;
        int lenB=0;
        
        while(curr != null){
            curr = curr.next;
            lenB++;
        }
        
        while(lenA < lenB){
            headB = headB.next;
            lenB--;
        }
        
        while(lenA > lenB){
            headA = headA.next;
            lenA--;
        }
        
        while(headA!=headB){
            headA = headA.next;
            headB = headB.next;
        }
        
        return headB;
        
    }
}