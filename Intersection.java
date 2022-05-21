// Time Complexity : O(n + m), n nodes in B to build hashmap, m nodes in B to traverse
// Space Complexity : O(n), n nodes in hashmap
// Did this code successfully run on Leetcode : on Geeks for Geeks yes
// Any problem you faced while coding this :

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
        Set<ListNode> nodesB = new HashSet<ListNode>();
        
        
        // iterate through nodes from headB and store in set
        while (headB != null){
            nodesB.add(headB);
            headB = headB.next;
        }
        
        while (headA != null){
            if (nodesB.contains(headA)){ // intersection
                return headA;
            }
            headA = headA.next;
        }
        return null;
    }
}