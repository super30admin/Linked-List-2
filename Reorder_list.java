/**
 * 
 */

/**
 * @author aupadhye
 *
 */

//Space complexity would be O(1) and time complexity would be O(1)
class Reorder_list
{ 
      
static class Node  
{ 
    int data; 
    Node next; 
} 
  
  
// function for rearranging a linked list 
// with high and low value. 
static Node rearrange(Node head) 
{ 
    if (head == null) // Base case. 
        return null; 
  
    // two pointer variable. 
    Node prev = head, curr = head.next; 
  
    while (curr != null)  
    { 
        // swap function for swapping data. 
        if (prev.data > curr.data) 
        { 
            int t = prev.data; 
            prev.data = curr.data; 
            curr.data = t; 
        } 
  
        // swap function for swapping data. 
        if (curr.next != null && curr.next.data > curr.data) 
        { 
            int t = curr.next.data; 
            curr.next.data = curr.data; 
            curr.data = t; 
        } 
  
        prev = curr.next; 
  
        if (curr.next == null) 
            break; 
        curr = curr.next.next; 
    } 
    return head; 
} 
  
static Node push(Node head, int k) 
{ 
    Node tem = new Node(); 
    tem.data = k; 
    tem.next = head; 
    head = tem; 
    return head; 
} 
  

static void display(Node head) 
{ 
    Node curr = head; 
    while (curr != null) 
    { 
        System.out.printf("%d ", curr.data); 
        curr = curr.next; 
    } 
} 
  
// Driver code 
public static void main(String args[]) 
{ 
  
    Node head = null; 
  
    // let create a linked list. 
    // 9 . 6 . 8 . 3 . 7 
    head = push(head, 7); 
    head = push(head, 3); 
    head = push(head, 8); 
    head = push(head, 6); 
    head = push(head, 9); 
  
    head = rearrange(head); 
  
    display(head); 
  
} 
} 
  
