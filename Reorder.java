// Time Complexity : O(n) where n is the length of the linked list.
// Space Complexity : O(1) no extra space
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


/* Your code here along with comments explaining your approach
1) Find the mid point of the linked list.
2) then reverse the second half of the linkedlist
3) now merge both the halfs as required.
*/ 


 //Definition for singly-linked list.
 class ListNode {
    int val;
   ListNode next;
   ListNode(int x) {
       val = x;
       next = null;
      }
}
class Solution {
    public void reorderList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        //find the mid point;
        while(fast != null && fast.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        //reverse the second half
        ListNode curr = slow.next;
        slow.next = null;
        ListNode prev = null;

        while(curr != null)
        {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }

        //now merge them
        ListNode lst1Head = head;
        ListNode lst2Head = prev;

        while(lst1Head != null && lst2Head != null)
        {
            ListNode temp = lst1Head.next;
            lst1Head.next = lst2Head;
            lst2Head = lst2Head.next;
            lst1Head.next.next = temp;
            lst1Head = temp;
        }

    }
}