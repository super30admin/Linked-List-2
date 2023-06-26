// Time Complexity : O(n)
// Space Complexity : O(1)
    // n is the number of nodes present in the linked list.

// Your code here along with comments explaining your approach
    //We take 2 pointers, currA and currB, initialized as the headA and headB respectively. We traverse until one of the "curr" pointer becomes null.
    //Then, it is reassigned as the head of the other list. We do that until currA is not equal to currB. 
    //When currA is equal to currB, the intersection is at currA or currB. If both are pointing to null and there is no intersection, then also we return currA(null).
    
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
        ListNode currA = headA;
        ListNode currB = headB;
        while(currA!=currB)
        {
            if (currA==null)
            {
                currA = headB;
            }
            else
            {
                currA = currA.next;
            }
            if (currB==null)
            {
                currB = headA;
            }
            else
            {
                currB = currB.next;
            }
        }
        return currA;
    }
}