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

 //Time O(n+m) where n and m are the sizes of the two linkedlists respectively
 //Space O(1)
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // Concept is to find out which linkedlist has more elements and then move the head of that linkedlist by the difference in length between the two lists. Now that it is moved, both of them will start at the same point relative to the intersection. Now just move both pointers together till they become equal.
        int lenA = 0;
        ListNode hdA = headA;
        while(hdA!=null)
        {
            hdA=hdA.next;
            lenA++;
        }
        int lenB=0;
        ListNode hdB=headB;
        while(hdB!=null)
        {
            hdB=hdB.next;
            lenB++;
        }
        while(lenB>lenA)
        { headB=headB.next;
          lenB--;
        }
        while(lenA>lenB)
        {   headA=headA.next;
            lenA--;
        }
        while(headA!=headB)
        {
            headA=headA.next;
            headB=headB.next;
        }
        return headA;
        
        
        
    }
}