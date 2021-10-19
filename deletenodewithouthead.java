//TC:O(1)
//SC:O(1)
//successfully ran
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
    void deleteNode(Node del)
    {
        if (del == null) // If linked list is empty
            return;
        else
        {
            if(del.next == null)
            {

                return;
            }

        Node temp = del.next;
         // Copy data of the next node to current node
        del.data = del.next.data;

        // Perform conventional deletion
        del.next = del.next.next;


        }

    }
}
