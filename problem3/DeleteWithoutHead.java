//Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
package problem3;

public class DeleteWithoutHead {
	public void deleteWithoutHead(ListNode node) {
		if (node == null || node.next == null) {
			return;
		}

		node.val = node.next.val;
		node.next = node.next.next;
	}

	public void printList(ListNode head) {
		ListNode temp = head;
		while (temp.next != null) {
			System.out.print(temp.val + " -> ");
			temp = temp.next;
		}
		System.out.print(temp.val);
	}

	public static void main(String[] args) {
		DeleteWithoutHead obj = new DeleteWithoutHead();

		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);

		System.out.println("List before removing node: ");
		obj.printList(head);
		obj.deleteWithoutHead(head.next.next);

		System.out.println("\nList after removing node:");
		obj.printList(head);
	}

}
