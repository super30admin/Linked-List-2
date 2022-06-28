// Time Complexity : O(1) 
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : No, Ran on GFG
// Any problem you faced while coding this : No

//Delete without head pointer
//https://practice.geeksforgeeks.org/problems/delete-without-head-pointer/1

class Problem3
{
    void deleteNode(Node del)
    {
         // Your code here
         Node temp = del.next; 
         del.next = del.next.next;
         del.data = temp.data; 
    }
}