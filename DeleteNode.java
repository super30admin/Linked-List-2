/**
 * // Time Complexity : O(1)
 * // Space Complexity : O(1)
 * // Did this code successfully run on Leetcode : Yes
 * // Any problem you faced while coding this :
 */

public class DeleteNode {
  void deleteNode(Node del) {
    Node temp = del.next;
    del.data = temp.data;
    del.next = temp.next;
  }
}
