TC: o(m+n)
SPace:o(1)

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
        int length1 = 0;
        int length2 = 0;
        
        ListNode curr1 = headA;
        ListNode curr2 = headB;
        
        while(curr1!= null)
        {
            length1++;
            curr1 = curr1.next;
            
        }
        while(curr2!= null)
        {
            length2++;
            curr2 = curr2.next;
            
        }
        ListNode slow = headA;
        ListNode fast = headB;

        while(slow != fast && slow != null)
        {
            if(length1>length2)
            {
                slow = slow.next;
                length1--;
            }
            else if(length2 > length1){
                fast = fast.next;
                length2--;
            }
            else{
                slow= slow.next;
                fast = fast.next;
            }
        }
        
        return slow;
    }
}
