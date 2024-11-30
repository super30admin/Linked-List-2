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
        int lenA=length(headA);
        int lenB=length(headB);
        while(lenA>lenB)
        {
            headA=headA.next;
            lenA--;
        }
        while(lenB>lenA)
        {
            headB=headB.next;
            lenB--;
        }
        while(lenA>0)
        {
            if(headA==headB)
                return headA;
            headA=headA.next;
            headB=headB.next;
            lenA--;
        }
        return null;
    }
    
    public int length(ListNode head)
    {
        int temp=0;
        while(head!=null)
        {
            temp++;
            head=head.next;
        }
        return temp;
    }
}

// Time Complexity: O(n), n is number of nodes
// Space Complexity: O(1), because we are not using an extra space