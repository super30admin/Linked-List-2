// Time Complexity :O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
// In this approach we first use a slow pointer and a fast pointer to find the mid point of the linked list. We then reverse the elements
// in the second half of the linked list. Now we have two parts of the linked list and we start from head of each linked list and keep
// appending the nodes to it.
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
      
     if(head == null)
      {
        return ;
      }

    
      //find the last element of the first half which will also be the mid point
      ListNode lastFirstHalf = findLastFirstHalf(head);
      //reverse the second half of the linked list
      ListNode firstSecondHalf = reverseList(lastFirstHalf.next);

      ListNode p1 = lastFirstHalf;
      p1.next = null;
      p1 = head;
      
      ListNode p2 = firstSecondHalf;
      
      while(p2!=null && p1!=null)
      {
        ListNode NextTemp1 = p1.next;
        ListNode NextTemp2 = p2.next;
        
        p1.next = p2;
        p2.next = NextTemp1;

        p1 = NextTemp1;
        p2 = NextTemp2;
      }
      
    }    
    //method to reverse a linkedlist
       private ListNode reverseList(ListNode head)
	{
		
		ListNode prev = null;
		ListNode current = head;
		
		while(current!=null)
		{
			ListNode nextTemp = current.next;
			current.next = prev;
			prev = current;
			current = nextTemp;
		}
		
		return prev;
		
	}
  //method to find the point where we want to divide the list
  private ListNode findLastFirstHalf(ListNode head)
	{
		ListNode slow = head;
		ListNode fast = head;
		
		while(fast.next!= null && fast.next.next!= null)
		{
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}
    
}