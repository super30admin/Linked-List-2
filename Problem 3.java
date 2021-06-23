// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : Found solution from googling, not sure how it works. Never seen System.gc() before


// Your code here along with comments explaining your approach

class Solution
{
    void deleteNode(Node node)
    {
         // Your code here
        Node temp = node.next;
        node.data = temp.data;
        node.next = temp.next;
        System.gc();
         
    }
}