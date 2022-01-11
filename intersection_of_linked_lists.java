// Time Complexity : O(n)
// Space Complexity : O(1)

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
        
        int l1= 0;
        int l2 = 0;
        
        ListNode curr = headA;
        
        // Calculate the length of first linked list
        while (curr != null){
            
            curr = curr.next;
            l1++;
        }
        
      
        // Calculate the length of the second linked list
        curr = headB;
        while ( curr != null){
            curr = curr.next;
            l2++;
        }
        
        
        // Update the head based on l1 and l2 lengths.
        while (l1 > l2 ){
            headA = headA.next;
            l1--;
        }
        
        while (l2 > l1){
            headB = headB.next;
            l2--;
        }
        
        // Increment the pointer till it reaches the intersection
        while (headA !=  headB){ 
            headA = headA.next;
            headB = headB.next;
        }
        
        return headA;
        
    }
}