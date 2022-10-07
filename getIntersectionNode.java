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
        int lenA=0;
        int lenB=0;
        ListNode temp=headA;
        while(temp!=null)
        {
            lenA++;
            temp=temp.next;
        }
        
        temp=headB;
        while(temp!=null)
        {
            lenB++;
            temp=temp.next;
        }
        temp=headB;
        while(lenA<lenB)
        {
            lenB--;
            temp=temp.next;
        }
        
        ListNode temp2=headA;
        while(lenA>lenB)
        {
            lenA--;
            temp2=temp2.next;
        }
        
        while(temp!=null || temp2!=null)
        {
            if(temp==temp2) return temp;
            temp=temp.next;
            temp2=temp2.next;
        }
        
        return null;
        
    }
}

// Time Complexity : O(M+N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no