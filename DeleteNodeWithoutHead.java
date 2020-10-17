package linkedList2;

/*
Idea : 1. We shift the pointer of the node to be deleted to the temp node, point temp node to next node,
		  and nullify temp node.

Time Complexity : O(1) because the node value is given to us.
Space Complexity : O(1) because we used constant extra space.

Did this code successfully run on Leetcode : yes
Any problem you faced while coding this : no
*/

public class DeleteNodeWithoutHead {
	
	static class Node{
        int data;
        Node next;
        Node(int d){
            data= d;
            next =null;
        }
    }
    void deleteNode(Node del)
    {
        Node temp = del.next;
        del.data = temp.data;
        del.next = temp.next;
        temp = null;
    }
    
   
}
