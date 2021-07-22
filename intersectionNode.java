// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null && headB == null)
            return headA;
        
        if(headA == null || headB == null)
            return null;
        
        ListNode tempA = headA, tempB = headB;
        int m = 0, n = 0;
        
        m = getListSize(headA);
        n = getListSize(headB);
        
        
        if(m > n)
            headA = moveHead(headA, m - n);
        else
            headB = moveHead(headB, n - m);
        
        //iterate until we reach the same head
        while(headA != null && headB != null){
            if(headA == headB){
                return headA;
            }
            headA = headA.next;
            headB = headB.next;
        }
        
        return null;
    }
    
    private int getListSize(ListNode head){
        int ctr = 0;
        while(head != null){
            head = head.next;
            ctr++;
        }
        return ctr;
    }
    
    private ListNode moveHead(ListNode head, int ctr){
        while(ctr != 0){
            head = head.next;
            ctr--;
        }
        
        return head;
    }
}