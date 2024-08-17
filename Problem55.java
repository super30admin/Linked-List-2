// Time Complexity : O(m+n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
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
public class Problem55 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // Initialize two pointers
        ListNode pA = headA;
        ListNode pB = headB;
        
        // Traverse the lists
        while (pA != pB) {
            // Move pA to the next node in listA, or to the head of listB if it's at the end of listA
            pA = (pA != null) ? pA.next : headB;
            // Move pB to the next node in listB, or to the head of listA if it's at the end of listB
            pB = (pB != null) ? pB.next : headA;
        }
        
        // pA and pB will either both be null (no intersection) or both point to the intersection node
        return pA;
    }
}
