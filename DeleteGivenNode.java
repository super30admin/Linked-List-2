// Time Complexity :1
// Space Complexity :1
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this : Firstly I was finding it difficult to traverse.


// Your code here along with comments explaining your approach
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) 
    {     //putting value of next node in the value to be deleted
          node.val=node.next.val;
          //setting the pointer to next pointer
          node.next=node.next.next;
    }
}