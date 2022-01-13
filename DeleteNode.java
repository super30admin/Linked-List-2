// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : ran on geeks for geek
// Any problem you faced while coding this : Yes

public class DeleteNode {
    public static void main(String[] args) {
        
    }
    void deleteNode(Node del)
    {
         // copy next node's value in the node to be deleted and delete the next node
         Node next = del.next;
         if(next != null){
             del.data = next.data;
             del.next = next.next;
         }
    }
    class Node
    {
        int data ;
        Node next;
        Node(int d)
        {
            data = d;
            next = null;
        }
    }
}
