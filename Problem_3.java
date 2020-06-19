// Time complexity - O(1)
// Space complexity - O(1)

// Create tmp node and point to node.next. Set node value to tmp value and move node pointer to tmp.next.

class Solution
{
  void deleteNode(Node node)
  {
       Node temp = node;
       temp=temp.next;
       node.data=temp.data;
       node.next=temp.next;
   }
