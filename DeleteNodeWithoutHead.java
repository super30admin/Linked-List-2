
//Idea: The node that we want to delete is given so just just update values of that node with next node values and 
//point that node to element where next node is pointing that is
//node.next =node.next.next


//Time complexity :O(1)

//Space complexity : O(1)
//Run on leetcode:yes

//any problem faced:yes I did not understand this solution fully.

class DeleteNodeWithoutHead{
	
	static class Node{
		int data;
		Node next;
		Node(int d){
			data= d;
			next =null;
		}
	}
	void deleteNode(Node del)
	{
		Node temp = del.next;
		del.data = temp.data;
		del.next = temp.next;
		temp = null;
	}
}