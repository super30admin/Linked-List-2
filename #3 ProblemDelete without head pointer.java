
//Delete without head pointer
//Time Complexity: O(1)
//Space Complexity: O(1)


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
class GfG
{
    void deleteNode(Node node)
    {
         // Your code here
    
        Node newCurrentNode = node.next;


        //setting node val and next pointer
        if(node.next != null){
            node.data = node.next.data;
            node.next = node.next.next;
        }
        
        
        
    }
}

