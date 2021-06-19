/* SC - O(1), TC - O(N)
 *Apprach - copy the data from next node of the node to be deleted to the node and repeat the action until the end of the list, 
 that way , we are ovewrriting the value of the node to be deleted   
 * */

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
    
    { 	Node prev =  null;
        
        while(del.next != null){
         	del.data = del.next.data;
                prev = del; // keep track of last but one node to make it null to avoid duplicates
                del = del.next;
         }
	 //  Make the next pointer of the last node as null otherwise there will be duplicate at end of the list
         prev.next = null;
         
    }
}

