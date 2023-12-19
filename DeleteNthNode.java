//T.C O(1)
//S.C O(1)
//As the head of the list is not given, it is not possible to get to the prev of node to delete the node.
//So, we can move the next nodes backward by replicating deleting node's next to the curr node and changing its pointer
//to next's next.

//{ Driver Code Starts
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

class Delete_Node
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

        int t = sc.nextInt();
        while(t>0)
        {
            int n = sc.nextInt();
            Delete_Node llist = new Delete_Node();
            //int n=Integer.parseInt(br.readLine());
            int a1=sc.nextInt();
            Node head= new Node(a1);
            llist.addToTheLast(head);
            for (int i = 1; i < n; i++)
            {
                int a = sc.nextInt();
                llist.addToTheLast(new Node(a));
            }

            int k = sc.nextInt();
            Node del = llist.search_Node(llist.head,k);

            DeleteNthNode g = new DeleteNthNode();
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
class DeleteNthNode
{
    void deleteNode(Node del)
    {
        Node temp = del.next;
        del.data = del.next.data;
        del.next = del.next.next;
        temp = null;
    }
}

