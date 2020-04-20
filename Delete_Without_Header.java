// Time Complexity :O(1)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :Yes, it ran on geek for geeks
// Any problem you faced while coding this :Saw a hint to get started


// Your code here along with comments explaining your approach

class GfG
{
    void deleteNode(Node node)
    {
         // Your code here
        if(node.next!=null){
          node.data = node.next.data;
          node.next = node.next.next;
        }else{
            node=null;
        }
    }
}