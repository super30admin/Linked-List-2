// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Approach: Because the node is passed by value, we can just update it val
// and next with the next node.

// LC 237. Delete Node in a Linked List

public class DeleteNodeInLLWithoutHead {
  public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
      next = null;
    }
  }

  public void deleteNode(ListNode node) {
    ListNode temp = node.next;
    node.val = temp.val;
    node.next = temp.next;
  }
}
