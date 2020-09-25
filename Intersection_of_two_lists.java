import java.util.LinkedList;
//Space complexity is O(1) and time complexity is O(m+n) since you have to traverse through m and n nodes 
// of list.
/**
 * 
 */

/**
 * @author aupadhye
 *
 */
class Intersection_of_two_lists { 
  
    static Node head1, head2; 
  
    static class Node { 
  
        int data; 
        Node next; 
  
        Node(int d) 
        { 
            data = d; 
            next = null; 
        } 
    } 
  
   
    int getNode() 
    { 
        int c1 = getCount(head1); 
        int c2 = getCount(head2); 
        int d; 
  
        if (c1 > c2) { // If count 1 is greater than count 2 , then iterate through the first list
            d = c1 - c2; 
            return _getIntesectionNode(d, head1, head2); 
        } 
        else { 
            d = c2 - c1; 
            return _getIntesectionNode(d, head2, head1); // If count 2 is greater than count 1, iterate through 
            //second list
        } 
    } 
  
   
    int _getIntesectionNode(int d, Node node1, Node node2) //Iteratre through the lists and find if the intersection node 
    // of list 1 and 2 is same or not 
    { 
        int i; 
        Node current1 = node1; 
        Node current2 = node2; 
        for (i = 0; i < d; i++) { 
            if (current1 == null) { 
                return -1; 
            } 
            current1 = current1.next; 
        } 
        while (current1 != null && current2 != null) { 
            if (current1.data == current2.data) { 
                return current1.data; 
            } 
            current1 = current1.next; 
            current2 = current2.next; 
        } 
  
        return -1; 
    } 
  
  
    int getCount(Node node) 
    { 
        Node current = node; 
        int count = 0; 
  
        while (current != null) { 
            count++; 
            current = current.next; 
        } 
  
        return count; 
    } 
  
    public static void main(String[] args) 
    { 
        Intersection_of_two_lists list = new Intersection_of_two_lists(); 
  
        // creating first linked list 
        list.head1 = new Node(3); 
        list.head1.next = new Node(6); 
        list.head1.next.next = new Node(9); 
        list.head1.next.next.next = new Node(15); 
        list.head1.next.next.next.next = new Node(30); 
  
        // creating second linked list 
        list.head2 = new Node(10); 
        list.head2.next = new Node(15); 
        list.head2.next.next = new Node(30); 
  
        System.out.println("The node of intersection is " + list.getNode()); 
    } 
} 