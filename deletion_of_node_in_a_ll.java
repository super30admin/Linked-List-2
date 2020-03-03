/**
 * 
 */


//Space complexity is O(1) and time complexity is O(n)
/**
 * 
 *
 * @author aupadhye
 *
 */
class deletion_of_a_node_in_ll
{ 
    Node head; 
  
 
    class Node 
    { 
        int data; 
        Node next; 
        Node(int d) 
        { 
            data = d; 
            next = null; 
        } 
    } 
  
  
    
   public void delete_node_without_head(Node position){
    	
    	if(position==null) {
    		return;//If position is null,delete
    	}
    	else {
    		
    	if(position.next==null)//If last node is encountered, then delete it
    	{
    		return;
    	}
    	
    	Node temp = position.next;// Get position temp of the next node
    	position.data = position.next.data; //assign current position node data from next node data
    	position.next = position.next.next;//set the pointer to next to next node 
    	
    	}
    }
 
    public void push(int new_data) 
    { 
        Node new_node = new Node(new_data); 
        new_node.next = head; 
        head = new_node; 
    } 
  
    public void printList() 
    { 
        Node tnode = head; 
        while (tnode != null) 
        { 
            System.out.print(tnode.data+" "); 
            tnode = tnode.next; 
        } 
    } 
  
 
    public static void main(String[] args) 
    { 
        deletion_of_a_node_in_ll llist = new deletion_of_a_node_in_ll(); 
  
        llist.push(7); 
        llist.push(1); 
        llist.push(3); 
        llist.push(2); 
  
        System.out.println("\nCreated Linked list is:"); 
        llist.printList(); 
  
        Node head = llist.head;
        Node delete = head.next;
        llist.delete_node_without_head(delete); // Delete node at position 4 
  
        System.out.println("\nLinked List after Deletion:"); 
        llist.printList(); 
    } 
} 
