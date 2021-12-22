// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
//Question: Function to delete a node without any reference to head pointer.
// If the next element is not null, copy the data/value of the next element to the current data/value and skip the next element
// If the next element is null, that means its the last element, so mark the element as null
class Solution
{
    void deleteNode(Node del)
    {
        // Your code here
        if (del == null) return;
        else if (del.next == null) {
            del = null;
        }
        else {
            del.data = del.next.data;
            del.next = del.next.next;
        }
    }
}

