package LinkedLists;

/**
 * Time: O(1)
 * Space: O(1)
 * Problems faced: NA
 */
public class DeleteNode {

	public static void main(String[] args) {
		ListNode head = new ListNode(10);
		head.next = new ListNode(20);
		head.next.next = new ListNode(4);
		head.next.next.next = new ListNode(30);
		deleteGivenNode(head.next);
		while(head != null) {
			System.out.println(head.val);
			head = head.next;
		}
	}

	private static void deleteGivenNode(ListNode node) {
		//Change the data variables of the given node to those of the next node
		node.val = node.next.val;
		node.next = node.next.next;
	}

}
