// Time Complexity :
//      n is the number of nodes in LL
//      deleteNode() - O(1)
//      
// Space Complexity :
//      deleteNode() - O(1)
//
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


class Solution {
    public void deleteNode(ListNode node) {

        if(node == null || node.next == null)
            node = null;
        
        int temp = node.next.val;
        node.next = node.next.next;
        node.val = temp;
    }
}