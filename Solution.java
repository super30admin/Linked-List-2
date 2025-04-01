
// Overall Time Complexity : O(m+n) + O(min(m,n))  since we traverse the linked list twice one for listA and listB  and final traversals to get the intersection
// Overall Space Complexity : O(1) 
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this : No issues faced during implementation

// Traverse both linked lists to calculate their lengths.
// Advance the pointer of the longer list to align both pointers at equal distance from the intersection.
// Traverse both lists together until the intersection node is found.


public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        int lenA = 0;
        int lenB = 0;
        
        ListNode curr = headA;
        while(curr!=null){
            curr = curr.next;
            lenA = lenA+1;
        }
        curr = headB;
        while(curr!=null){
            curr= curr.next;
            lenB = lenB+1;
        }
        
        while(lenA>lenB){
            headA = headA.next;
            lenA--;
        }
        while(lenB>lenA){
            headB = headB.next;
            lenB--;
        }
        
        while(headA!=headB){
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }
}
