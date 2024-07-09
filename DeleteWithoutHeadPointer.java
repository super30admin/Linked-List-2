// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*
class Node
{
	int data ;
	Node next;
	Node(int d)
	{
		data = d;
		next = null;
	}
}
*/

//Function to delete a node without any reference to head pointer.
class Solution
{
  void deleteNode(Node del_node)
  {
    // Non existant or last node.
    if(del_node == null || del_node.next == null) {
      return;
    }
    // Copy value from next node and skip the next node.
    del_node.data = del_node.next.data;
    del_node.next = del_node.next.next;
  }
}