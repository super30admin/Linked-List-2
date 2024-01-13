// Time Complexity :O(1)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach: i copy the next node value of the target node into the target node.
class Solution
{
    void deleteNode(Node del)
    {
         // Your code here
         if(del==null || del.next==null){
              return;
         }
         
         del.data= del.next.data;
         del.next=del.next.next;
    }
    
}
