// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this : No

//Time Complexity : O(n power 2) since we are iterating through all the nodes multiple times until they meet
//Space Complexity: O(1) since we are not taking any extra space

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            var currA = headA;
            var currB = headB;

            while(currA != currB)
            {
                if(currA == null)
                {
                    currA = headB;
                }
                else
                {
                    currA = currA.next;
                }

                if(currB == null)
                {
                    currB = headA;
                }
                else
                {
                    currB = currB.next;
                }
            }

            return currA;
    }
}