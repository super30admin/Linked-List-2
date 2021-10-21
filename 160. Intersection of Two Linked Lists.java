// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


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
        int n=0;
       int m=0;
       ListNode nodeA=headA;
        ListNode nodeB=headB;
        
            while(headA!=null ){
            n=n+1;
        headA=headA.next;
            
        }
    
     while(headB!=null){
            m=m+1;
        headB=headB.next;
            
        }
    
        if (m>n){
            while(m-n!=0 && nodeB!=null){
                m--;
                nodeB=nodeB.next;
            }
        }
        
         if (m<n){
            while(n-m!=0 && nodeA!=null){
                n--;
                nodeA=nodeA.next;
            }
        }
        
        while(nodeA!=null){
              if(nodeA==nodeB){
               
                return nodeA;
            }
             nodeA=nodeA.next;
                nodeB=nodeB.next;
          
           
        }
        return null;
        
    }
}