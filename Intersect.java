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
        
        //edge
        if(headA == null || headB == null){
            return null;
        }
        
        while(headA != null){
            map.put(headA,0);
            if(headA.next == null){
                break;
            }
            headA = headA.next;
        }
        
        while(headB != null){
            if(map.containsKey(headB)){
                return headB;
            }
            if(headB.next == null){
                break;
            }
            headB = headB.next;
        }
        return null;
    }
}