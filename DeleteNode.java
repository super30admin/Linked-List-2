// Time Complexity : O(1) 
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// We have to delete a Node without headAccess. It is given the node is not a tail node. Copy the next element data into the current node and delete the link to the next node. (It is like deleting the node next to it)

class Solution {
    public void deleteNode(Node del) {
        if(del == null || del.next == null) return;
        
        del.data = del.next.data;
        Node tmp = del.next;
        del.next = del.next.next;
        tmp.next = null; // deleting the link to that node
    }
}