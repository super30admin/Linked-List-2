// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

class GfG
{
    void deleteNode(Node node)
    {
        Node nextNode=node.next;
        node.data=nextNode.data;
        node.next=nextNode.next;
        
         // Your code here
    }
}