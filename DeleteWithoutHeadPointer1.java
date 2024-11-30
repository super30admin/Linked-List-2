// Time Complexity :O(1)
// Space Complexity :O(1)
// Did this code successfully run on GeeksforGeeksEditor : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

class Solution
{
    void deleteNode(Node del)
    {	
    	 //copy the next data of del node into delete node
         del.data = del.next.data;

         //move the pointer inorder to skip del node
         del.next = del.next.next;
    }
}