

// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
/*Approach
1) we do not need to send the head pointer, thus need not to worry about retrieving the head pointer.
2) we can simulate as if the node to be deleted has been replaced as we do not have access to the head pointer.
3) we just copy the value of next node to the original node
4) and then for refrence we can make use of next node, 
    -> org list 1->2->3->4  Node to be deleted: 2
    we can only access 2
       | 
    1->2->3->4

    1->3->3->4
          |
    we delete the node pointed at which is next 3 and we point node from first 3 to directly to 4
*/





class DeletNodeWithoutHeadPointer
{

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
    void deleteNode(Node del)
    {
         // Your code here
         
         if(del==null)
         {
             return ;
         }
         
         del.data = del.next.data;
         del.next = del.next.next;
         
         
    }
}