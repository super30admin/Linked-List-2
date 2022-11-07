// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this : no


public class DelWithoutHP {
    public void deleteNode(ListNode node) {
        node.val=node.next.val;          // copy the next node's value into the current node
        node.next=node.next.next;       // connect the current node to the next of next node

    }
}
