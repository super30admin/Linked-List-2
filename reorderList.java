//time complexity O(n) (n/2 for finding mid + n/2 for reversing + n for merging but we ignore constants)
//space complexity O(1) no extra space used
//Did this code successfully run on Leetcode : yes
//Any problem you faced while coding this : no

/**
 * The first while loop is to find the mid of the linked list using slow and fast pointer approach.
 * The second step is to reverse the second half of the linked list since that is the part which we need to merge in the first half to get the desired result. The reverse function does that.
 * The third step is to merge the two halves of the linked list as per the required order which is L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class reorderList {
    public void reorderList(ListNode head) {

        ListNode slow=head;
        ListNode fast=head;

        while(fast.next!=null && fast.next.next!=null)
        {
            slow=slow.next;
            fast=fast.next.next;
        }

        fast=reverse(slow.next);
        slow.next=null;
        slow=head;
    
        while(slow!=null && fast!=null)
        {
            ListNode temp=slow.next;
            slow.next=fast;
            fast=fast.next;
            slow.next.next=temp;
            slow=temp;
        }

        return ;

        
    }
    public ListNode reverse(ListNode head)
    {
        ListNode curr=head;
        ListNode prev=null;
        while(curr!=null)
        {
            ListNode temp=curr.next;
            curr.next=prev;
            prev=curr;
            curr= temp;
        }
        return prev;
    }
}