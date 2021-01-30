// Time Complexity :o(1)
// Space Complexity :o(1)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

/*

Swap currNode data with forwardNode data;
Point the currNode to nex node of forward;

*/

class DeleteNode
{
    void deleteNode(Node node)
    {
         // Your code here
         
         Node curr=node;
         Node forward=node.next;
         
         
         int currVal=curr.data;
         curr.data=forward.data;
         forward.data=curr.data;
         curr.next=forward.next;
         
         
         
    }
}
