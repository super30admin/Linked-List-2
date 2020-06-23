
class ListNode2 {
	int val;
	ListNode2 next;

	ListNode2(int x) {
		val = x;
	}
}

class Delete_Node {
	public void deleteNode(ListNode2 node) {
		node.val = node.next.val;
		node.next = node.next.next;
	}
}