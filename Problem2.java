// Time Complexity :O(n+n/2)traversal of whole list + adding stack element to list
// Space Complexity :O(n/2) for stack
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
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
        if(head==null || head.next==null)
            return;
        
        ListNode slow=head;
        ListNode fast=head;
        
        while(fast.next!=null && fast.next.next!=null)//finding the middle element
        {
            slow=slow.next;
            fast=fast.next.next;
        }
        
       Stack<ListNode> st= new Stack<>();
        while(fast.next==null &&slow.next!=null)//adding all the elements on the stack after the middle element has been found
            {
                st.push(slow.next);
                slow=slow.next;
            }
         while(fast.next!=null &&slow!=null)
            {
                st.push(slow);
                slow=slow.next;
            }
        
        ListNode n= head;
        while(!st.isEmpty())//removing fromstack and adding after element in the original list untill stack is empty.
        {
            ListNode temp=n.next;
            n.next=st.pop();
            n.next.next=temp;
            n=n.next.next;
        }
        n.next=null;
    }
}