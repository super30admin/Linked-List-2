// Time Complexity :O(1)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :Nope.


// Your code here along with comments explaining your approach

class DeleteNodeWithoutHead
{
    void deleteNode(Node node)
    {
         if(null != node){
             Node next = node.next;
             if(null != next){
                 node.data = next.data;
                 node.next = next.next;
             }else{
                 node = null;
             }
         }
    }
}