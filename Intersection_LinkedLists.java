// Time Complexity :O(m+n)-where m and n are nodes of the linked lists
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA==null||headB==null){
            return null;
        }
        
        ListNode current = headA;
        int lengthA = 1;
        while(current.next!=null){
            lengthA++;
            current=current.next;
        }
        
        current = headB;
        int lengthB=1;
        while(current.next!=null){
            lengthB++;
            current=current.next;
        }
        
        while(lengthA>lengthB){
            headA=headA.next;
            lengthA--;
        }
        
        while(lengthB>lengthA){
            headB=headB.next;
            lengthB--;
        }
        
        while(headA!=headB){
            headA = headA.next;
            headB = headB.next;
        }
        
        return headA;
    }
}