// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/*
1. Calculate the length of both the arrays
2. Keep going on the bigger array until the length become the same
3. Then move both the pointers together unitl they meet
*/


// Your code here along with comments explaining your approach
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode tempHeadA = headA;
        ListNode tempHeadB = headB;
        
        int lengthA = 0;
        int lengthB = 0;
        
        while(tempHeadA!=null) {
            tempHeadA = tempHeadA.next;
            lengthA++;
        }
        
        while(tempHeadB!=null) {
            tempHeadB = tempHeadB.next;
            lengthB++;
        }
        
        while(lengthA>lengthB) {
            headA = headA.next;
            lengthA--;
        }
        
        while(lengthB>lengthA) {
            headB = headB.next;
            lengthB--;
        }
        
        while(headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }
        
        return headB;
    }
}
