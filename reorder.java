// Time Complexity :O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach: as per given contarint i have done this withut using extra space fist i find the mid by taking two pointers slow is moving 1x whereas fast is moving 2x while fast reaches null then my slow pointer at mid of list the i have reversed the second part of list from slow.next to fast then i change the links to the nodes as per required order of output;


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
        while(fast.next != null && fast.next.next != null){
            slow=slow.next;
            fast=fast.next.next;
        }
        fast=reverse(slow.next);
        slow.next=null;
        slow=head;
        while(fast != null){
            ListNode temp=slow.next;
            slow.next=fast;
            fast=fast.next;
            slow.next.next=temp;
            slow=temp;
        }
    }
     public ListNode reverse(ListNode current){
              ListNode prev=null;
           while(current != null) {
              ListNode temp=current.next;
           current.next=prev;
            prev=current;
            current=temp;
        }
        return prev;
        }
}