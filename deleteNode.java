// Time Complexity :O(N)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

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
    void deleteNode(Node node){
         while(node.next.next != null){
             node.data = node.next.data;
             node=node.next;
         }
         node.data= node.next.data;
         node.next=null;
    }
}
