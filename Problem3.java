//Time Complexity: O(1)
//Space Complexity: O(1)
//Code run successfully.

public class Problem3 {

	 void deleteNode(Node del)
	    {
	         Node temp = del.next;
	         del.data = temp.data;
	         del.next = del.next.next;
	         
	    }
}
