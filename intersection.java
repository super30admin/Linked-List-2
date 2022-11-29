// Time Complexity : O(n)
// Space Complexity :O(1)
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA==null || headB==null) return null;
        int len1=0;
        int len2=0;
        ListNode curr=headA;
      
        while(curr!=null){
            len1++;
            curr=curr.next;
        }
        curr=headB;
        while(curr!=null){
            len2++;
            curr=curr.next;
        }
        
        while(len1>len2){
            headA=headA.next;
            len1--;
        }
        
        while(len2>len1){
            headB=headB.next;
            len2--;
        }
        
        while(headA!=headB){
                headA=headA.next;
                headB=headB.next;
        }
        
        return headA;
        
    }
}