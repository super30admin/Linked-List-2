// Time Complexity : O(n) 
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :
public class GetIntersectionNode {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA  == null || headB == null){
            return null;
        }
        
        ListNode cur = headA;
        int lenA =0, lenB=0;
        while(cur!=null){
            cur = cur.next;
            lenA++;
        }
        cur = headB;
        while(cur!=null){
            cur=cur.next;
            lenB++;
        }
        
        while(lenA>lenB){
            headA = headA.next;      
            lenA--;
        }
        
        while(lenB>lenA){
            headB = headB.next;
            lenB--;
        } 
        
        while(headA != headB){
            headA = headA.next;
            headB = headB.next;
        }
        
        return headA;
    }
}