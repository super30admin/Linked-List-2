// TC: O(1) since we are using constant time
// SC : O(1) since we are using constant space

// We do not have reference to start pointer of the Linked list. So we replace the node value to be deleted with its next pointer value. 
// Now we have one extra pointer with same value. we will assign current pointer(new value assigned node) to next to next pointer which will ensure that 
// by replacing value with next value and referencing the next to next pointer, we are deleting the node value and not just changing the reference.
public class DeleteHeadPtr {

	public void DeleteNode(ListNode node) {
		
		node.data = node.next.data;
		node.next = node.next.next;
	}
	
	public static void main(String[] args)
	{
		DeleteHeadPtr dn = new DeleteHeadPtr();
		ListNode node = new ListNode(4);
		node.next = new ListNode(5);
		node.next.next = new ListNode(0);
		node.next.next.next = new ListNode(1);
		
		dn.DeleteNode(node.next);
		
		while(node!=null) {
			System.out.println(node.data);
			node = node.next;
		}
	}
}
