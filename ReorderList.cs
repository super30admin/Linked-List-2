using System;
using static Algorithms.Linked_List_Reverse;

namespace Algorithms
{
    public class ReorderList
    {
        /// Time Complexity : O(N) 
        // Space Complexity :O(1) 
        // Did this code successfully run on Leetcode :Yes
        // Any problem you faced while coding this :  No 
        public void ReorderListAlg(ListNode head)
        {

            if (head == null) return;
            //find middle
            ListNode slow = head;
            ListNode fast = head;
            while (fast != null && fast.next != null)
            {
                slow = slow.next;
                fast = fast.next.next;
            }
            //reverse second list
            ListNode prev = null;
            ListNode curr = slow;
            ListNode tmp;

            while (curr != null)
            {
                tmp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = tmp;
            }
            //merge two lists

            ListNode first = head;
            ListNode second = prev;
            while (second.next != null)
            {
                tmp = first.next;
                first.next = second;
                first = tmp;

                tmp = second.next;
                second.next = first;
                second = tmp;
            }
        }
    }
}
