// Time Complexity : O(N) -> N = number of elements in the list
// Space Complexity : O(1)
// Did this code successfully run on GeekforGeeks : Yes
// Any problem you faced while coding this : Took time to figure out.


// Your code here along with comments explaining your approach

// Using a pointer to navigate in the list
// Once I reach the second last element I 
// break out from the loop and update the currPtr 
// to the value of the next node and set the next
// to null

class GfG
{
    void deleteNode(Node node)
    {
        Node currPtr = node;        
        while(currPtr.next.next != null) {   
            currPtr.data = currPtr.next.data;
            currPtr = currPtr.next;
        }
        currPtr.data = currPtr.next.data;
        currPtr.next = null;
    }
}
