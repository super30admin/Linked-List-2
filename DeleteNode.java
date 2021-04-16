// Time Complexity :O(1)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :

// Your code here  with comments explaining your approach

class Solution {
  void deleteNode(Node del) {
    // copy the next node's value into the current node
    del.data = del.next.data;
    // point the current node to next node
    del.next = del.next.next;
  }
}