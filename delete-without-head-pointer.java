// Time Complexity :
O(1)
// Space Complexity :
o(1)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

/*Since we are given just the pointer to the node to be deleted, we can 
copy the data of this pointer next data.
Now we can make this pointer next to point to pointer.next.next*/


class Solution {
    
    public deleteWithoutHead(TreeNode root) {
    pointer.data = pointer.next.data;
    pointer.next = pointer.next.next;

    }

