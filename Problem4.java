// https://leetcode.com/problems/intersection-of-two-linked-lists/description/
// Time Complexity : O(m+n) where m and n are the lengths of the two linked lists
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lengthA = 0;
        int lengthB = 0;
        ListNode currA = headA;
        ListNode currB = headB;
        while (currA != null) {
            lengthA++;
            currA = currA.next;
        }
        while (currB != null) {
            lengthB++;
            currB = currB.next;
        }
        currA = headA;
        currB = headB;
        while (lengthA > lengthB) {
            currA = currA.next;
            lengthA--;
        }
        while (lengthB > lengthA) {
            currB = currB.next;
            lengthB--;
        }
        while (currA != currB) {
            currA = currA.next;
            currB = currB.next;
        }
        return currA;
    }
}