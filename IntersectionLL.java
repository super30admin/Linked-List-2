// Time Complexity : O(m + n) where m is length of Linked list A and n is length of Linked List B.
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None
/* Your code here along with comments explaining your approach: Get the length of linked list A and B. This gives an idea on how far the shorter length
linked list pointer is from the bigger length linked list. We need to fill that gap. Hence, move the longer length linked list pointer to fill upto
'gap' steps so that both the pointers are on the same positions at their respective linked list. Start traversing the linked list from that position
till the end and if there is an intersection, both the pointers will surely meet else no intersection is there.
*/
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null){return null;}                    // edge case
        ListNode tempA = headA;
        ListNode tempB = headB;
        int lenA = 0, lenB = 0;
        while(tempA != null){lenA++; tempA = tempA.next;}                   // Get length of LL A
        while(tempB != null){lenB++;  tempB = tempB.next;}                  // Get length of LL B
        int steps  = 0;
        tempA = headA;
        tempB = headB;
        if(lenA > lenB){
            while(steps < (lenA-lenB)){                                     // Fill the gap by longer length LL steps 
            tempA = tempA.next;
            steps++;
            }
        } else {
            while(steps < (lenB-lenA)){
            tempB = tempB.next;
            steps++;
            }
        }
        while(tempA != null && tempB != null){                              // Since the pointers are now in the same starting positions in their respective LL
            if(tempA == tempB){                                     // Intersection found
                return tempA;
            }
            tempA = tempA.next;
            tempB = tempB.next;
        } 
        
        return null;                                                // Intersection does not exist
    }
}