// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

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

class GfG
{
    void deleteNode(Node node)
    {
         // Your code here
         //have a temp to hold the next noed you don't want to lose reference 
         Node temp = node.next;
         //nnow change the current node's refernce to node.next
         node.data = node.next.data;
         //now make current nodes next equal the current nodes next next cause you are skipping over one
         node.next = node.next.next;
         //change temp next to null
         temp.next = null;
    }
}