// Time Complexity : O(M+N)
//Space Complexity : O(1) 
//Did this code successfully run on Leetcode : Yes

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        
        ListNode p1 = headA;
        ListNode p2 = headB;
        int lengthA = 0;
        int lengthB = 0;
        
        while(p1 != null){
            p1 = p1.next;
            lengthA++;
        }
        
        
        
        while(p2 != null){
            p2 = p2.next;
            lengthB++;
        }
        
        while(lengthA > lengthB)
        {
            headA = headA.next;
            lengthA--;
        }
        while(lengthB > lengthA)
        {
            headB = headB.next;
            lengthB--;
        }
        
        while(headA != headB){
            headA = headA.next;
            headB = headB.next;
        }
        
        return headA;
    }
}