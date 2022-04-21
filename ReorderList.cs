using System;
using System.Collections.Generic;
using System.Text;

namespace LinkedList
{
    public class ReorderList
    {
        /*
         * T.C: O(N) since we are traversing through all nodes of list
         * S.C: O(1) no extra space used
         */
        public void GenerateReorderList(ListNode head)
        {

            if (head == null || head.next == null)
                return;

            ListNode slow = head;
            ListNode fast = head;

            while (fast.next != null && fast.next.next != null)
            {
                slow = slow.next;
                fast = fast.next.next;
            }

            fast = reverseList(slow.next);
            slow.next = null;

            slow = head;
            ListNode temp = null;

            while (fast != null)
            {
                temp = slow.next;
                slow.next = fast;
                fast = fast.next;
                slow.next.next = temp;
                slow = temp;

            }

        }

        private ListNode reverseList(ListNode head)
        {
            ListNode prev = null;
            ListNode curr = head;
            ListNode fast = head.next;

            while (fast != null)
            {
                curr.next = prev;
                prev = curr;
                curr = fast;
                fast = fast.next;
            }
            curr.next = prev;

            return curr;
        }
    }
}
