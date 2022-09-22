// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No.
// Your code here along with comments explaining your approach
/*
Swap the elements from give node and its right side nodes, delete the final tail node.
* */
public class DeleteHeadNode {
    void deleteNode(Node del)
    {
        // Your code here
        if(del==null) return;

        Node prev=null;
        while(del.next!=null){
            prev=del;
            del.data=del.next.data;
            del=del.next;
        }
        prev.next=null;
    }
}
