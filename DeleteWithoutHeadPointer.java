// Time Complexity : O(1) .
// Space Complexity : O(1) no extra space used.
// Any problem you faced while coding this :


// We set current value/data to next.data. then current.next = current.next.next if current.next is not null;   
//Success
//Details 
 // Correct Answer.Correct Answer
//Execution Time:1.75

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
class GfG
{
    void deleteNode(Node node)
    {
         // Your code here
         node.data=node.next.data;
         node.next=node.next.next;
    }
}

