// Time Complexity : o (n)
// Space Complexity : o(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach


class Solution
{
   public void deleteNode(Node del)
   {
    Node temp=del;
    temp=temp.next;
    del=temp;
   }

}