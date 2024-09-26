//Time Complexity : O(n)
//Space Complexity : O(1)

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
        
        int headA_count = 0;
        int headB_count = 0;
        
        ListNode head_A = headA;
        ListNode head_B = headB;
        
        while(head_A!=null)
        {
            headA_count++;
            head_A = head_A.next;
        }
        
        while(head_B!=null)
        {
            headB_count++;
            head_B = head_B.next;
        }
        
        head_A = headA;
        head_B = headB;
        
        while(headA_count > headB_count)
        {
            head_A = head_A.next;
            headA_count--;
        }
        
        while(headA_count < headB_count)
        {
            head_B = head_B.next;
            headB_count--;
        }
        
        while(head_A!=head_B)
        {
            head_A= head_A.next;
            head_B= head_B.next;
        }
        
        return head_B;
    }
}