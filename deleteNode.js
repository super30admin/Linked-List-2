// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on GeeksForGeeks : Yes
// Any problem you faced while coding this : No

//Function to delete a node without any reference to head pointer.
class deleteNode {
    
    deleteNode(del)
    {
        //your code here
        let temp = del.next;
        del.data = temp.data;
        del.next = temp.next;
    }
}