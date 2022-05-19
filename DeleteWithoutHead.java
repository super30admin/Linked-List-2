/*
Time: O(1) : No traversal needed
Time: O(1) : No extra space needed
*/
public class DeleteWithoutHead {
    static Node head;
    static void deleteNode(Node del)
    {
         del.data = del.next.data;
         del.next = del.next.next;
    }

    static class Node{
        int data ;
        Node next;
    
        Node(int d){
            data = d;
            next = null;
    	}
    }


public static void main(String[] args) {
    head = new Node(1);
    head.next = new Node(2);
    head.next = new Node(3);

    print(head);
    
    deleteNode(head.next);
    print(head);
    
}

private static void print(Node head){
    Node node = head;
    while(node != null){
        System.out.print(node.data +" -> ");
        node = node.next;
    }
    System.out.println();
    return;
}
}