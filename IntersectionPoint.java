// Time Complexity : O(N)
// Space Complexity : O(!)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO


// Your code here along with comments explaining your approach

public class IntersectionPoint {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode curA = headA;
        ListNode curB = headB;
        
        int size1 = 0,size2 =0;
        
        for(; curA != null; curA = curA.next){
            size1++;
        }
        for(; curB != null; curB = curB.next){
            size2++;
        }
        curA = headA;
        curB = headB;
        if(size1 > size2 ){
            int diff = size1 - size2;
            for(int i=0; i < diff; i++){
                curA = curA.next;
            }
        }
        else {
            int diff = size2 - size1;
            for(int i=0; i < diff; i++){
                curB = curB.next;
            }
        }
        while(curA != curB){
            curA = curA.next;
            curB = curB.next;
        }
        
        return curA;
        
    }
}