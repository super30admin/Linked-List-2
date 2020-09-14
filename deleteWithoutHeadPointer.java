    /*  Explanation
    # Leetcode problem link : https://practice.geeksforgeeks.org/problems/delete-without-head-pointer/1
    Time Complexity for operators : o(1) 
    Extra Space Complexity for operators : o(1) 
    Did this code successfully run on Leetcode : Yes
    Any problem you faced while coding this : No
# Your code here along with comments explaining your approach
        # Basic approach : 

        # Optimized approach same like basic approach: Recursion or Iterative.
                              
                #
                    A. take value of next node to the current node
                    B. And then remove the connection from current and next node.  

       */

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

   class reorderList {

    public void deleteWithoutHeadPointer(ListNode headA) {

        headA.val = headA.next.val;
        head.next = head.next.next;
    }
}