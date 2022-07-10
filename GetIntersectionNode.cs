using System;
using static Algorithms.Linked_List_Reverse;

namespace Algorithms
{
    /// Time Complexity : O(M+N) 
    // Space Complexity :O(1) 
    // Did this code successfully run on Leetcode :Yes
    // Any problem you faced while coding this :  No 
    public class GetIntersectionNode
    {
        public ListNode GetIntersectionNodeAlg(ListNode headA, ListNode headB)
        {
            ListNode curr = headA;
            int lenA = 0;
            while (curr != null)
            {
                curr = curr.next;
                lenA++;
            }

            curr = headB;
            int lenB = 0;
            while (curr != null)
            {
                curr = curr.next;
                lenB++;
            }

            while (lenA > lenB)
            {
                headA = headA.next;
                lenA--;
            }

            while (lenB > lenA)
            {
                headB = headB.next;
                lenB--;
            }

            while (headA != headB)
            {
                headA = headA.next;
                headB = headB.next;
            }

            return headA;

        }
    }
}
