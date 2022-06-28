/*
This approach solves the problem in three steps. In the first step, we find the midpoint of the linked list by
using a fast and a slow pointer. Then, reverse the list that is after the midpoint, and seperate it from the
midpoint, after which we will re-order the list The re-ordering logic is to print out the first element, then 
the last element, then the second element, then the second last element and so on, till the final element which 
would be the midpoint.

Did this code run on leetcode: Yes
*/
class Solution {
    //Time Complexity = O(n)
    //Space Complexity = O(1)
    public void reorderList(ListNode head) 
    {
        
        if(head == null || head.next == null || head.next.next == null)
            return;
        
        //Finding the middle of the linked list
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast.next != null && fast.next.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        //slow is now at the midpoint
        fast = reverse(slow.next);
        slow.next = null;
        slow = head;
        //Reordering the list
        while(fast != null)
        {
            ListNode temp = slow.next;
            slow.next = fast;
            fast = fast.next;
            slow.next.next = temp;
            slow = temp;
        }
    }
    
    private ListNode reverse(ListNode head)
    {
        ListNode prev = null;
        ListNode curr = head;
        ListNode fast = head.next;
        
        while(fast != null)
        {
            curr.next = prev;
            prev = curr;
            curr = fast;
            fast = curr.next;
        }
        
        curr.next = prev;
        return curr;
    }
}