//Time Complexity : O(1)
//Space Complexity : O(1)

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

//Function to delete a node without any reference to head pointer.
class Solution
{
    void deleteNode(Node del)
    {
         // Your code here
         if(del==null){
             return;
         }
         //update the value of del node with the next node's value
         del.data = del.next.data;
         if(del.next!=null){
         //connect the del node to the node after the next node
             del.next = del.next.next;
         }
    }
}