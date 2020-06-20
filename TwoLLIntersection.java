// Time Complexity :O(n). n is the number of nodes in the list
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
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
        
        int firstLLCount=0,secondLLCount=0;
        ListNode firstLL=headA,secondLL=headB;
        
        while(firstLL!=null){
            firstLL=firstLL.next;
            firstLLCount++;
        }
        
        while(secondLL!=null){
            secondLL=secondLL.next;
            secondLLCount++;
        }
        
        while(firstLLCount>secondLLCount){
            headA=headA.next;
            firstLLCount--;
        }
        
        while(secondLLCount>firstLLCount){
            headB=headB.next;
            secondLLCount--;
        }
        
        while(headA!=headB){
            headA=headA.next;
            headB=headB.next;
        }
        
        if(headA==headB) return headA;
        else return null;
        
        
    }
}
