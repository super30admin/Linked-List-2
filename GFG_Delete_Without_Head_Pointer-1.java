// Delete without head pointer - https://practice.geeksforgeeks.org/problems/delete-without-head-pointer/1
// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : On geeksforgeeks
// Any problem you faced while coding this : No

/*Time Complexity: 
For printing linked list: O(N)
For inserting node: O(1)
For deleting node: O(N)
Auxiliary Space: O(1) */
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

//Function to delete a node without any reference to head pointer.
class Solution
{
    void deleteNode(Node del)
    {
        Node temp = del.next;
        del.data = temp.data;
        del.next = temp.next;
        temp = null;
    }
}

// ----------------------------------------------------------|||||||||||||||||||||||||||------------------------------------------------------- \\

// WHOLE CODE 

class LinkedList {
    Node head; // head of the list

    class Node {
        int data;
        Node next;
        Node(int d)
        {
            data = d;
            next = null;
        }
    }

    /* Given a reference to the head of a list and an int,
        inserts a new Node on the front of the list. */
    public void push(int new_data)
    {
        /* 1. alloc the Node and put the data */
        Node new_Node = new Node(new_data);

        /* 2. Make next of new Node as head */
        new_Node.next = head;

        /* 3. Move the head to point to new Node */
        head = new_Node;
    }

    /* This function prints contents of linked list 
        starting from the given Node */
    public void printList()
    {
        Node tNode = head;
        while (tNode != null) {
            System.out.print(tNode.data + " ");
            tNode = tNode.next;
        }
    }

    public void deleteNode(Node Node_ptr)
    {
        Node temp = Node_ptr.next;
        Node_ptr.data = temp.data;
        Node_ptr.next = temp.next;
        temp = null;
    }

    public static void main(String[] args)
    {
        LinkedList llist = new LinkedList();

        /* Use push() to construct below list
        1->12->1->4->1  */
        llist.push(1);
        llist.push(4);
        llist.push(1);
        llist.push(12);
        llist.push(1);

        System.out.println("Before deleting");
        llist.printList();

        /* I m deleting the head itself.
        You can check for more cases */
        llist.deleteNode(llist.head);

        System.out.println("\nAfter Deleting");
        llist.printList();
    }
}