// Time Complexity : O(1)
// Space Complexity : O(1) no extra space
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


/* Your code here along with comments explaining your approach
1) Find the mid point of the linked list.
2) then reverse the second half of the linkedlist
3) now merge both the halfs as required.
*/ 
class Solution {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}