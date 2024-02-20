// ## Problem3 (https://practice.geeksforgeeks.org/problems/delete-without-head-pointer/1)
// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Ran on geeksforgeeks
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution
{
    void deleteNode(Node del)
    {
         if(del==null)  return;
         
         // Exchange data of next node with given node, and delete the next node
         int temp=del.data;
         del.data=del.next.data;
         del.next.data=temp;
         
         // Now delete "del.next" node
         Node tempNode=del.next;
         del.next=tempNode.next;
         tempNode.next=null;
    }
}
