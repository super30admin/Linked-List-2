// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

public class IntersectionTwoNodes {
    public class Solution {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

            int lenA = getLength(headA);
            int lenB = getLength(headB);

            if(lenA > lenB){
                while(lenA != lenB){
                    headA = headA.next;
                    lenA--;
                }
            }
            else{
                while(lenB != lenA){
                    headB = headB.next;
                    lenB--;
                }
            }

            while(headA != null && headB != null){
                if(headA == headB){
                    return headA;
                }
                headA = headA.next;
                headB = headB.next;
            }

            return null;
        }

        private int getLength(ListNode head){
            int len = 0;
            while(head != null){
                len++;
                head = head.next;
            }
            return len;
        }
    }
}
