// Time Complexity :O(1)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Ran properly on GeeksForGeeks
// Any problem you faced while coding this : No

class GfG
{
    void deleteNode(Node node)
    {
        node.data = node.next.data;
        node.next = node.next.next;
         
    }
}