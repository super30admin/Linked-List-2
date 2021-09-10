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
// Time Complexity: O(n+m) where n is size of 1st list and m is size of 2nd list
// Space Complexity: O(n+m) where n is size of 1st list and m is size of 2nd list
// Did you complete it on leetcode: Yes
// Any problems faced: No

// Write your approach here
// Approach here is to create a set of ListNodes, which would be unique.
// If there exists an intersection where 2 lists meet then that would be the 1st ListNode to appear which would be repeating in set.
// As soon as we find it, we need to return the node.
// Else we can return null
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> set = new HashSet<>();
        if(headA==null || headB==null) return null;
        while(headA!=null) {
            set.add(headA);
            headA = headA.next;
        }
        while(headB!=null) {
            if(set.contains(headB)) return headB;
            headB = headB.next;
        }
        return null;
    }
}