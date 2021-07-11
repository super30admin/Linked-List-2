// Time Complexity : O(n)
// Space Complexity : O(1) -- height of the tree
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode currA = headA;
        ListNode currB = headB;
        while(currA != null && currB != null){
            currA = currA.next;
            currB = currB.next;
        }
        while(currA != null){
            currA = currA.next;
            headA = headA.next;
        }
        while(currB != null){
            currB = currB.next;
            headB = headB.next;
        }
        while(headA != headB){
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
        
        
    }
}