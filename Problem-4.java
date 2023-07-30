// Time Complexity : O(2n) = O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Solution: calculate length of both lists, then move headA/headB by the diff of lenA - lenB, 
// then move both pointers together and when both headA and headB
//becomes equal, that is the intersection point. That is is the idea of implementation.
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        
        int lenA = 0;
        int lenB = 0;
        ListNode curr = headA;
        while(curr!=null){
            curr = curr.next;
            lenA++;
        }  

        curr = headB;
        while(curr!=null){
            curr = curr.next;
            lenB++;
        }  

        while(lenA>lenB){
            headA= headA.next;
            lenA--;
        }

        while(lenB>lenA){
            headB= headB.next;
            lenB--;
        }

        while(headA!=headB){
            headA= headA.next;
            headB= headB.next;
        }

        return headA;
        
    }
}