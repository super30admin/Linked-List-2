/ Function to delete a node without any reference to head pointer.
// copies the data from the next node into the current node and then bypasses the next node by adjusting the pointer.
//Time complexity: O(1)
//Space complexity: O(1)
class Solution

{

   void deleteNode(Node node)

   {

       Node temp = node;

       temp=temp.next;

       node.data=temp.data;

       node.next=temp.next;

   }
}