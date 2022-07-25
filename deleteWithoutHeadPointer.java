// Time Complexity :O(N)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach

void deleteNode(Node del)
{
     // Your code here
     if(del.next == null){
         del=null;
     }else{
         del.data = del.next.data;
         del.next = del.next.next;
     }
}