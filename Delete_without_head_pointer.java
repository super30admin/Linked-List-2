/**** Method 1 ****/
//Time Complexity: O(n)
//Space Complexity: O(1)

//Successfully submitted in LeetCode

//As we do not know the head node, we have only one option to delete the node, i.e not deleting the node but changing the values of nodes and removing the last node. We start by replacing the node.val with node.next.val and keep note of last but one node as we need to set its next as null.

public class Delete_without_head_pointer {

  public void deleteNode(ListNode del_node) {
    ListNode last = new ListNode();

    while (del_node.next != null) {
      del_node.val = del_node.next.val;
      if (del_node.next.next == null) {
        last = del_node;
      }
      del_node = del_node.next;
    }

    last.next = null;
  }
}
