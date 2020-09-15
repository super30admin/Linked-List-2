// Time Complexity : O(N) 
// Space Complexity : o(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        
        int sizeA = 0;
        int sizeB = 0;
        
        ListNode nodeA = headA;
        ListNode nodeB = headB;
        
        while(nodeA !=null){
            nodeA=nodeA.next;
            sizeA+=1;
        }
        
        while(nodeB !=null){
            nodeB=nodeB.next;
            sizeB+=1;
        }
        
        nodeA=headA;
        nodeB=headB;
        
        if(sizeA>sizeB){
            while(sizeA!=sizeB){
                 sizeA-=1;
                 nodeA=nodeA.next;
            }  
        }else{
            while(sizeA!=sizeB){
                sizeB-=1;
                nodeB=nodeB.next;
           } 
        }
        
        while(nodeA!=null && nodeB!=null){
            if(nodeA==nodeB){
                return nodeA;
            }
            nodeA=nodeA.next;
            nodeB=nodeB.next;
        }
        return null;
    }
}