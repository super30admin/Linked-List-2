
// Time Complexity : O(m)+O(n) 
// Space Complexity :O(1)
//Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :

public class IntersectionPoint {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        
        int lenA=0;
        int lenB=0;
        
        ListNode a = headA;
        ListNode b = headB;
        
        while(a!=null){
            lenA++;
            a = a.next;
        }
         while(b!=null){
            lenB++;
            b = b.next;
        }
         a = headA;
         b = headB;
        while(lenA>lenB){
            a= a.next;
            lenA--;
        }
        while(lenB>lenA){
            b= b.next;
            lenB--;
        }
        while(a!=b){
            a= a.next;
            b= b.next;
        }
        
        return a;
        
    }
}
