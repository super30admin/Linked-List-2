// Time Complexity : O(1)
// Space Complexity : O(1) 
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO


// Your code here along with comments explaining your approach
class GfG
{
    void deleteNode(Node node)
    {
         // Set value of curr node to next node value
         // and remove link to next node
         node.data = node.next.data;
         node.next = node.next.next;
    }
}
