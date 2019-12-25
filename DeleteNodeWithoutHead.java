/*
Space Complexity : O(1)
Time Complexity : O(N)
Approach: We iterate the list and then assign data from next node to current node and increase pointer to next node.
*/

/*This is a function problem.You only need to complete the function given below*/

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
class GfG
{
    void deleteNode(Node node)
    {
         // Your code here
         while(node.next != null){
             if(node.next.next != null){
                node.data = node.next.data;
                node = node.next; 
             }else{
                  node.data = node.next.data;
                  node.next = null;
             }
         }
    }
}