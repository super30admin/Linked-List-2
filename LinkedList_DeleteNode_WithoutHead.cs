using System;
using static Algorithms.Linked_List_Reverse;

namespace Algorithms
{
    public class LinkedList_DeleteNode_WithoutHead
    {
        /// Time Complexity : O(1) 
        // Space Complexity :O(1) 
        // Did this code successfully run on Leetcode :Yes
        // Any problem you faced while coding this :  No 
        public void DeleteNode(ListNode node)
        {
            node.val = node.next.val;
            node.next = node.next.next;
        }
    }
}
