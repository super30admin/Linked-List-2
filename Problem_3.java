// Time Complexity :O(1)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


//I have also written the driver code for parsing the entries.

// 2
// 2
// 1 2
// 1
// 4
// 10 20 41 30
// 20

//here we interchange the value first ant hen remove the element next to the element ot be removed.

package PackageProblem;

import java.util.Arrays;
import java.util.Scanner;

public class DeletingElement {
	Node head;

	class Node {
		int data;
		Node next;

		Node(int d) {
			this.data = d;
			this.next = null;
		}
		Node() {
			
			this.next = null;
		}
	}

	public Node createLinkedList(int[] arr) {
		if (arr.length == 0) {
			return null;
		} else if (arr.length == 1) {
			head = new Node(arr[0]);
			return head;
		}
		head = new Node(arr[0]);
		Node temp = head;
		for (int i = 1; i < arr.length; i++) {
			Node newNode = new Node(arr[i]);
			temp.next = newNode;
			temp = temp.next;
		}
		return head;
	}

	public void printAllElements(Node head) {
		if (head == null) {
			return;
		}
		Node temp = head;
		while (temp != null) {
			System.out.print(temp.data + "->");
			temp = temp.next;
		}
		System.out.println("null");
		System.out.println();
	}
	

	public void findElement(Node head, int element) {
		if(head==null) {
			return ;
		}

		
		//Here we will find the element and the then pass the reference to it in the delete method.
		Node temp=head;
		while(temp.data!=element) {
			temp=temp.next;
		}
		System.out.println("element is"+temp.data);
		deleteElement(temp);
		
	}
	
	public void deleteElement(Node toDelete) {
		//thus this is the last element
		if(toDelete.next==null) {
			toDelete=toDelete.next;
			System.out.println("hell"+toDelete.data);
			return ;
		}
		int tempVal=toDelete.next.data;
		toDelete.data=tempVal;
		toDelete.next=toDelete.next.next;
		
	}

	public static void main(String[] args) {
		Scanner obj = new Scanner(System.in);

		System.out.println("Enter the number of test cases");
		int count = obj.nextInt();
		for (int i = 0; i < count; i++) {
			// System.out.println(i);
			System.out.println("Enter the number of elements");
			int size = obj.nextInt();
			System.out.println(size);
			int[] arr = new int[size];
			for (int j = 0; j < size; j++) {
				System.out.println("Enter element at " + j + " index");
				arr[j] = obj.nextInt();
			}
			DeletingElement del = new DeletingElement();
			Node head = del.createLinkedList(arr);
			del.printAllElements(head);
			System.out.println("Enter the element that you want to delete");
			int element = obj.nextInt();
			del.findElement(head,element);
			del.printAllElements(head);

		}
	}

}


