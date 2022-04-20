// Time complexity: O(1).
// Space complexity: O(1).

// { Driver Code Starts
    import java.util.*;

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
    
    public class Delete_Node
    {
        Node head;
        Node tail;
        
        void printList(Node head)
        {
            Node tnode = head;
            while(tnode != null)
            {
                System.out.print(tnode.data+ " ");
                tnode = tnode.next;
            }
            System.out.println();
        }
        
        void addToTheLast(Node node)
        {
            
            if(head == null)
            {
                head = node;
                tail = node;
            }
            else
            {
                tail.next = node;
                tail = node;
            }
        }
        
        Node search_Node(Node head, int k)
        {
            Node current = head;
            while(current != null)
            {
                if(current.data == k)
                    break;
                current = current.next;
            }
        return current;
        }
        
        public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            
            int t = sc.nextInt();       // Number of test cases.
            while(t>0)
            {
                int n = sc.nextInt();   // Number of nodes in the list.
                Delete_Node llist = new Delete_Node();
                //int n=Integer.parseInt(br.readLine());
                int a1=sc.nextInt();        // Head of the list.
                Node head= new Node(a1);
                llist.addToTheLast(head);
                for (int i = 1; i < n; i++) 
                {
                    int a = sc.nextInt();   // Values in the list after head.
                    llist.addToTheLast(new Node(a));
                }
                
                int k = sc.nextInt();       // Value(node) to be deleted.
                Node del = llist.search_Node(llist.head,k);
                
                Solution g = new Solution();
                if(del != null && del.next != null)
                {
                    g.deleteNode(del);
                }
                llist.printList(llist.head);
            t--;
            }
        }
    }
    
    
    // } Driver Code Ends
    
    
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
        public void deleteNode(Node del)
        {
             // Your code here
             del.data = del.next.data;
             del.next = del.next.next;
             
        }
    }
    
    