
// Time Complexity : O(1) as we just need to copy int data from one node to anothre and relink
// Space Complexity : O(1) as we're not using any auxiliary space
// Did this code successfully run on Leetcode/GFG: yes
// Any problem you faced while coding this :

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
class DeleteWithoutHead
{
    void deleteNode(Node del)
    {
        // Your code here
        Node copy = del.next;
        //given that del will never be a tail, so copy pointer will not be null

        del.data = copy.data;
        Node next = copy.next;

        del.next = next;
        copy.next = null;
    }
}
