// Time Complexity :O(n). n is the number of nodes
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :No

//code explanation
1)Divided the linked list in to two halves.
2)Reversed the nodes in the second half;
3)Then, added second half to the first half every alternative node

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
   // ListNode prevNode = null;
    public void reorderList(ListNode head) {
        
        if(head==null || head.next==null) return;
        
        ListNode l1=head;
        ListNode firstHalfEndPtr=null;
        ListNode middlePtr=head;
        ListNode secondHalfFirstPtr=head;
        
        while(secondHalfFirstPtr!=null && secondHalfFirstPtr.next!=null){
            firstHalfEndPtr=middlePtr;
            middlePtr=middlePtr.next;
            secondHalfFirstPtr=secondHalfFirstPtr.next.next;
        }
        firstHalfEndPtr.next=null;
        ListNode l2=  reverseSecondHalf(middlePtr);
        mergeTwoHalves(l1,l2);
    }
    
    public ListNode reverseSecondHalf(ListNode node){
        ListNode prev=null,curr=node,fast=node.next;
        while(fast!=null){
            curr.next=prev;
            prev=curr;
            curr=fast;
            fast=fast.next;
        }
        curr.next=prev;
        return curr;
        
    }
    
    public void mergeTwoHalves(ListNode firstHalfPtr,ListNode secondHalfPtr){
        while(firstHalfPtr!=null || secondHalfPtr!=null){
            ListNode firstHalfPtrNext=firstHalfPtr.next;
            ListNode secondHalfPtrNext = secondHalfPtr.next;
            
            firstHalfPtr.next=secondHalfPtr;
            
            if(firstHalfPtrNext==null) break;
            secondHalfPtr.next=firstHalfPtrNext;
            firstHalfPtr=firstHalfPtrNext;
            secondHalfPtr=secondHalfPtrNext;
            
            
        }
    }
}
