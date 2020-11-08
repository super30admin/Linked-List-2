//Time Complexity : O(1)
//Space Complexity : O(1)
//Did this code successfully run on GeeksForGeeks : Yes
//Any problem you faced while coding this : No


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

//This function should delete node from linked list. The function
//may assume that node exists in linked list and is not last node
//node: reference to the node which is to be deleted


class Delete_Node_Without_Head {
	  void deleteNode(Node node)
	    {
	        Node temp = node.next;
	        node.data = temp.data;
	        node.next = temp.next;
	    }
}