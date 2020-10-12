// Time Complexity :O(2N)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach: Using 2 pointer and reversing the second half and adding the head of list  1 and list 2

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
        
        if(headA == null || headB == null)
            return null;
        
        ListNode ptra = headA;
        ListNode ptrb = headB;
        
        while(ptra != ptrb){
            if(ptra == null){
                ptra = headB;
            }
            else if(ptrb == null){
                ptrb = headA;
            }
            else{
               ptra =  ptra.next;
               ptrb =  ptrb.next;
            }
        }
        return ptra;
    }
}
