class ListNode{
	int val;
	ListNode next;
	ListNode(int val){
		this.val = val;
		this.next = null;
	}
}

class DeleteWithoutHead{

	public void deleteNode(ListNode node){
		if(node == null){
			return;
		}

		ListNode curr = node.next;

		node.val = curr.val;
		node.next = curr.next;
		curr = null;
	}
}