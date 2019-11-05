// Time Complexity :O(n)
// Space Complexity :1
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :I was getting null pointer exception and after reversal,I was inserting the node in a wrong manner

// Your code here along with comments explaining your approach
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void reorderList(ListNode head) {
        //taking two pointers and initialising to head
        ListNode slow=head;
        ListNode fast=head;
        //when head is null or there is one element only simply return
        if(head==null || head.next==null)return;
        //putting condition on fast so it does not go to null and reaches the possible last
        while(fast.next!=null && fast.next.next!=null)
        {
            //incrementing slow to one and fast to two to get middle of the list
            slow=slow.next;
            fast=fast.next.next;
        }
        //reverse the entire list after middle and putting fast pointer on the starting of reversed list.
        fast=reverseList(slow.next);
        //taking a listnode temp and separating the list from middle onwards
        ListNode temp;
        slow.next=null;
        //putting slow pointer to head
        slow=head;
        //now inserting the elements of reversed list
        while(slow!=null && fast!=null)
        {
            //assigning next to slow in temp
            temp=slow.next;
            //to insert the element pointing slow's next to fast
            slow.next=fast;
           //incrementing fast pointer to get next value to be inserted
            fast=fast.next;
            //now finally pointing fast's next pointer to temp which was slow's next previously
             slow.next.next=temp;
            //assigning temp to slow to further insert the values.
            slow=temp;
            
        }
        
        
    }
    private ListNode reverseList(ListNode head)
    {
        ListNode temp=null;
        ListNode curr=head;
        while(curr.next!=null)
        {
            temp=curr.next;
            curr.next=temp.next;
            temp.next=head;
            head=temp;
        }
        return head;
    }
}
