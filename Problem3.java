// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes, successfully ran on Geekfoegeeks
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

import java.util.*;

// Definition for singly-linked list.
class Node {
     int data;
     Node next;
     Node() {}
     Node(int data) { this.data = data; }
     Node(int data, Node next) { this.data = data; this.next = next; }
}

public class Problem3 {
    
    public static void deleteNode(Node del) {
        // if del is the last node, set del to null
        if (del.next == null) {
            del = null;
        } else { // Else copy data of next node to del node and delete the next node
            del.data = del.next.data;
            Node prev = del;
            Node curr = prev.next;
            prev.next = curr.next;
            curr = null;
        } 
    }

    public static Node makeLinkedList(int[] arr) {
        Node head = null;
        for (int i = 0; i < arr.length; i++)
            head = insertNode(head, arr[i]);
        return head;
    }

    private static Node insertNode(Node head, int data) {
        Node temp = new Node(data);
        if (head == null)
            head = temp;
        else {
            Node curr = head;
            while (curr.next != null)
                curr = curr.next;
            curr.next = temp;
        }
        return head;
    }

    public static Node searchNode(Node head, int delvalue) {
        Node curr = head;
        while (curr != null) {
            if (curr.data == delvalue) {
                break;
            }
            curr = curr.next;
        }
        return curr;
    }

    public static void printLinkedList(Node head) {
        Node curr = head;
        List<Integer> ans = new ArrayList<Integer>(); 
        while (curr != null) {
            ans.add(curr.data);
            curr = curr.next;
        }
        System.out.println(ans);
    }
 
    public static void main(String args[]) {
        int arr[] = {10,20,4,30};
        Node head = makeLinkedList(arr);
        // printLinkedList(head);
        int delvalue = 20;
        Node del = searchNode(head, delvalue);
        deleteNode(del);
        printLinkedList(head);
    }
}
