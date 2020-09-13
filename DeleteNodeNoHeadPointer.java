/*
 * you are not given the head node or the reference/pointer to the head node but you are guven the reference/pointer to the node which is to be deleted from the linked list of N nodes. you have to delete that node only with this much of information. 

Input Format:
First line of input contains number of testcases T. For each testcase, first line of input contains length of linked list and next line contains the data of the linked list. The last line contains the node to be deleted.

Output Format:
For each testcase, in a newline, print the linked list after deleting the given node.

Your Task:
This is a function problem. You only need to complete the function deleteNode that takes reference to the node that needs to be deleted. The printing is done automatically by the driver code.

Constraints:
1 <= T <= 100
1 <= N <= 103

Example:
Input:
2
2
1 2
1
4
10 20 41 30
20

Output:
2
10 41 30

Explanation:
Testcase 1: After deleting 20 from the linked list, we have remaining nodes as 10, 41 and 30
 */


/*
 * Time Complexity of deleting node: O (1) -> Since, we are not traversing through the LL elements
 * 
 * Space Complexity: O (1) -> No extra space
 * 
 * Did this code successfully run on leetcode: Yes
 * 
 * Any problem you faced while coding this: No
 * 
 */

package com.s30.edu.linkedlist2;

// Definition of a Node
class Node { 
    int data; 
    Node next; 
    Node(int d) 
    { 
        data = d; 
        next = null; 
    } 
} 

public class DeleteNodeNoHeadPointer {
	
	Node head; // head of the list 

	
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
	
	/*
	 * Function to delete a node without reference to the head node
	 * This is where the concept of copying data from next node comes into picture
	 */
	public void deleteNode(Node node) {
		// #1. Find the next node of a node to be deleted
		Node nextNode = node.next;
		
		// #2. Copy the data of next node into the node to be deleted
		node.data = nextNode.data;
		
		// #3. Update the next pointer of a node to be deleted to the next pointer of the next node
		// Here, we cannot do node.next = node.next.next, as it will delete the next node and not the given node
		node.next = nextNode.next;
		
		// #4. Set the next node to null
		nextNode = null;
	}
	
	// Print the LL elements
	public void printList() 
    { 
        Node tNode = head; 
        while (tNode != null) { 
            System.out.print(tNode.data + " "); 
            tNode = tNode.next; 
        } 
    } 
	
	// main method
	public static void main(String[] args) {
		DeleteNodeNoHeadPointer list = new DeleteNodeNoHeadPointer();
		
		  /* Use push() to construct below list 
        1->12->1->4->1  */
        list.push(1); 
        list.push(4); 
        list.push(1); 
        list.push(12); 
        list.push(1); 
        
        System.out.println("Before deleting"); 
        list.printList();
        
        // Delete the first node in LL
        list.deleteNode(list.head);
        
        System.out.println("\nAfter Deleting"); 
        list.printList();
	}

}
