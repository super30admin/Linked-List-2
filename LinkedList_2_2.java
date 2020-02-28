//TimeComplexity: O(n)
//Space Complexity: O(1)
//leetcode: yes
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
        ListNode pa = headA;
        ListNode pb = headB;
        
        while(pa!=pb){
            
            if(pa!=null)pa = pa.next;
            else pa = headA;
            
            if(pb!=null)pb=pb.next;
            else pb = headB;
        }
        return pa;
    }
}