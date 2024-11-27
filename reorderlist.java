// Time Complexity : O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :
//approach: first we identify the middle of the list, reverse the second half of the list. then we take two pointers slow and fast.
//slow is on the first half of the list, fast is on the second half of the list. we rearrange such that alterante elements of each list 
//are present.

// Your code here along with comments explaining your approach
public class reorderlist {
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
class Solution {
    public void reorderList(ListNode head) {
        ListNode slow=head;
        ListNode fast=head;
        while(fast!=null && fast.next!=null)
        {
            slow=slow.next;
            fast=fast.next.next;
        }
        fast=reverse(slow.next);
        slow.next=null;
        slow=head;
        while(fast!=null)
        {
            ListNode temp=slow.next;
            //ListNode temp1=fast.next;
            slow.next=fast;
            fast=fast.next;
            slow.next.next=temp;
            slow=temp;
        }

    }
    public ListNode reverse(ListNode head)
    {
        if(head==null) return null;
        ListNode prev=null;
        ListNode cur=head;
        ListNode temp=cur.next;
        while(temp!=null)
        {
            cur.next=prev;
            prev=cur;
            cur=temp;
            temp=temp.next;
        }
        cur.next=prev;
        return cur;
    }
}
    
}
