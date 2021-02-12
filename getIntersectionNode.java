// Time Complexity : O(n)
// Space Complexity : O(1) 
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO


// Your code here along with comments explaining your approach
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        
        ListNode temp;
        // length of A
        temp = headA;
        int len = 0;
        while(temp!=null) {
            temp=temp.next;
            len++;            
        }
        
        // length of B
        temp = headB;
        while(temp!=null) {
            temp=temp.next;
            len--;            
        }
        
        // find diff(abs(a-b)) 
        // ans traverse bigger list by difference
        // both list will be at same distance from intersection
        if(len>0) {
            
            // list A is longer so move its head ahead by len
            while(len>0) {
                headA=headA.next;
                len--;
            }
            
        } else if(len<0) {
            
            // list B is longer
            while(len<0) {
                headB = headB.next;
                len++;
            }
            
        }
        
        
        // move pointers of both list until we reach intersection
        while(headA!=null) {
            if(headA==headB) return headA;
            headA=headA.next;
            headB=headB.next;
        }
        
        return null;
    }
}
