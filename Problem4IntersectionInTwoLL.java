// Time Complexity : O(m+n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
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
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA==null || headB==null) return null;
        
        int lenA=0;
        int lenB=0;
        ListNode curr=headA;
        while(curr!= null){ //find len of headA
            lenA++;
            curr=curr.next;
        }
        curr=headB;
         while(curr!= null){ //find len of headB
            lenB++;
            curr=curr.next;
        }
        
        while(lenA>lenB){ //traverse till both lens are equal from intersection
            lenA--;
            headA=headA.next;
        }
        
        while(lenB>lenA){
            lenB--;
            headB=headB.next;
        }
        
        while(headA != headB){ 
            headA=headA.next; 
            headB=headB.next;
        }
        return headA;
        
    }
}