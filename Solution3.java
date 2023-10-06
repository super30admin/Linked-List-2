// Leetcode Problem : https://leetcode.com/problems/delete-node-in-a-linked-list/description/
// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*
 * I assign temp to node.next and temp1 to node. While temp!=null, I set node.val = temp.val and set temp1=node.
 * I traverse node to node.next and temp to temp.next. I then set temp1.next to null.
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) {
        ListNode temp = node.next,temp1=node;
        while(temp!=null)
        {
            node.val=temp.val;
            temp1=node;
            node=node.next;
            temp=temp.next;
        }
        temp1.next=null;
    }
}