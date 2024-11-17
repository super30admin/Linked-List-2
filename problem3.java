//Problem3 (https://practice.geeksforgeeks.org/problems/delete-without-head-pointer/1)
// Time Complexity :
// O(1), since we are only updating the value of the current node and modifying the next pointer.
// The operation does not require traversing the entire linked list.

// Space Complexity :
// O(1), as no additional data structures are used. We are only using constant space for a few variable assignments.

// Did this code successfully run on Leetcode :
// Yes

// Any problem you faced while coding this :
// No
// Your code here along with comments explaining your approach
/*
    Approach:
    1. The goal is to delete the given node from the linked list, but we do not have access to the head pointer.
    2. We are given the node to be deleted and assume that it is not the last node in the list.
    3. Instead of actually deleting the node, we copy the value from the next node into the current node and then bypass the next node.
    4. This effectively removes the next node from the linked list, making it seem as if the current node was deleted.
    5. This approach only works if the node to be deleted is not the tail node, as the tail node cannot be removed using this method.
*/

public class problem3 {
      public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }

    public void deleteNode(ListNode node) {

        node.val = node.next.val;
        node.next= node.next.next;

    }
}
