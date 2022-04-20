// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// First of all, we find the length of both the list. Then we will traverse the larger list until the remaining length of both lists become equal. After that we will traverse both list by moving the pointer one step at a time. After that we will return the point where both the pointers become equal.

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA==null||headB==null)
            return null;
        ListNode currA = headA;
        ListNode currB = headB;
        int lenA = 0;
        int lenB = 0;
        while(currA!=null){
            lenA++;
            currA = currA.next;
        }
        while(currB!=null){
            lenB++;
            currB = currB.next;
        }
        currA = headA;
        currB = headB;
        while(lenA>lenB){
            currA = currA.next;
            lenA--;
        }
        while(lenA<lenB){
            currB = currB.next;
            lenB--;
        }
        while(currA!=currB){
            currA = currA.next;
            currB = currB.next;
        }
        return currA;
    }
}