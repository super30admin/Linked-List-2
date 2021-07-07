// Time Complexity : O(m+n) , where m and n is the length of the 2 Linked List
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :



//Given 2 LL - A and B
//find length of both from start to end
//find the difference between the two lengths and move the longer LL by the difference
//compare the nodes of the two LL, return when equal

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        
        ListNode nodeA = headA;
        ListNode nodeB = headB;
        
        //find lengths of the 2 LL
        int lenA = 0;
        int lenB = 0; 
        
        //find length of headA LL
        while(nodeA != null) {
            lenA++;
            nodeA = nodeA.next;
        }
        
        //find length of headB LL
        while(nodeB != null) {
            lenB++;
            nodeB = nodeB.next;
        }
        
        //point nodes back to head
        nodeA = headA;
        nodeB = headB;
        
        //if A is longer
        //move A by the difference of length
        while(lenA > lenB) {
            nodeA = nodeA.next;
            lenA--; 
        }
        
        //if B is longer
        //move B by the difference of length
        while(lenB > lenA) {
            nodeB = nodeB.next;
            lenB--; 
        }
        
        //Compare the two LL 
        while(nodeA != nodeB) {
            nodeA = nodeA.next;
            nodeB = nodeB.next;
        }
        
        //return nodeA or nodeB both point to first common node
        return nodeA;     
                
    }
}

