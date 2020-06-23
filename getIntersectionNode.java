// Time Complexity : O(m+n) m and n are sizes of two lists
// Space Complexity :O(m)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

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
        Set<ListNode> set = new HashSet<>();
        
        while(headA!=null)
        {
            set.add(headA);
            headA = headA.next;
        }
        
        while(headB!=null)
        {
            if(set.contains(headB)) return headB;
            headB = headB.next;
        }
        
        return null;
    }
}