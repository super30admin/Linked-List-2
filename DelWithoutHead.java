// Time Complexity : O(1), no traversal
// Space Complexity : O(1), no extra space
// Did this code successfully run on Leetcode : yes
// Three line explanation of solution in plain english : since we do not have access to prev node, we can update the values of the node to be deleted with values of it's next node.
// Then delete the next node.

class Solution
{
    //Function to delete a node without any reference to head pointer.
	void deleteNode(Node del)
	{
	    //storing the node next to given node in a pointer.
		Node temp = del.next;
		
		//copying the data of pointer in the given current node.
		del.data = temp.data;
		
		//storing the next node to pointer in link part of current node.
		del.next = temp.next;
		
		// freeing memory.
		temp = null;
	}
}
