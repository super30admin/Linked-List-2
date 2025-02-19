// Time Complexity all functions: O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


/*
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
*/

/* 
Function to delete a node without any reference to head pointer.
From the node, swap data in node and next node. Do this till the end of list making node as node.next. At the end, remove last node which will 
have data to be deleted.
*/
class DeleteWithoutHeadPointer {
    void deleteNode(Node node) {
        if(node.next==null){
            node=null;
            return;
        }
        Node prev=node;
        while(node.next!=null){
            int t=node.next.data;
            node.next.data=node.data;
            node.data=t;
            prev=node;
            node=node.next;
        }
        prev.next=null;
    }
}
