// Time Complexity : O(N+M)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Nope


// Your code here along with comments explaining your approach
// Take 2 pointers, one for each list and traverse each list
// Keep traversing the lists till both pointer point to the same node
// If any of the pointer becomes null reset it to the head of the other list
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
       
        if(headA == null || headB == null)
            return null;

        ListNode currA = headA;
        ListNode currB = headB;
        
        while(currA != currB) {
            currA = currA == null ? headB: currA.next;
            currB = currB == null ? headA: currB.next;            
        }
        
        return currA;
    }
}