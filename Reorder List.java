// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Your code here along with comments explaining your approach
//We will set two pointers slow and fast. Move slow at 1x speed and fast at 2x, so that when the fast reaches the end of the node, the slow pointer is in the middle of the list. 
//The nodes after the slow pointer need to be reversed. Then after reversing the second half of the list we merge the list before the slow pointer and the reversed list after it.

class Solution {
    public void reorderList(ListNode head) {
        //null
        if(head==null || head.next==null || head.next.next==null) return;
        ListNode slow=head,fast=head;
        //Find the Middle
        while(fast.next!=null && fast.next.next !=null)
        {
            slow=slow.next;
            fast=fast.next.next;
        }

        //Reverse
        fast=reverseList(slow.next);
        //set the node next to the slow pointer as null
        slow.next=null;
        //Reset the slow pointer to head
        slow=head;
        //Merge
        while(fast!=null)
        {
            ListNode temp=slow.next;
            slow.next=fast; //Connecting slow to the fast node
            fast=fast.next; //Moving the fast pointer to the next node
            slow.next.next=temp; //connecting the fast head to the next value in List 1
            slow=temp; // Moving the slow pointer 

        }
    }


private ListNode reverseList(ListNode head)
{
    ListNode prev=null,curr=head,temp=head.next;

    while(temp!=null)
    {
        curr.next=prev;
        prev=curr;
        curr=temp;
        temp=temp.next;
    }
    curr.next=prev;
    return curr;
}
}