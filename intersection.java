// Time Complexity : O(N)
// Space Complexity :O(N)
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
        HashMap<ListNode, Integer> map = new HashMap<>();
        
        if(headA == null || headB == null){	// base case
            return null;
        }
        
        while(headA != null){		// traverse through the headA nodes and put all the elements in the map
            map.put(headA,0);
            if(headA.next == null){
                break;
            }
            headA = headA.next;
        }
        
        while(headB != null){
            if(map.containsKey(headB)){		// once we find the first node which is intersecting then, return the current else keep checking
                return headB;
            }
            if(headB.next == null){
                break;
            }
            headB =headB.next;
        }
        return null;		// if no intersection is found
    }
}