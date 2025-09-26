// Time Complexity : O(m+n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        ListNode currA = headA, currB = headB;

        while(currA != currB){
            currA = currA.next;
            currB = currB.next;

            if(currA == null && currB == null) return null;

            if(currA == null){
                currA = headB;
            }

            if(currB == null){
                currB = headA;
            }
        }

        return currA;
    }
}
