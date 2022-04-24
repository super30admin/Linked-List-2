// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
//point current node value and next to node next val and next respectively.
public void DeleteNode(ListNode node) {
    if(node == null)
        return;
    
    node.val = node.next.val;
    node.next = node.next.next;
}