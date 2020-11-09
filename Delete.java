
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

// This function should delete node from linked list. The function
// may assume that node exists in linked list and is not last node
// node: reference to the node which is to be deleted

// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :nopes
class Delete
{
    void deleteNode(Node node)
    {

        if(node==null)
            return;

        if(node.next==null)
            node=null;


        node.data=node.next.data;

        node.next=node.next.next;


    }
}

