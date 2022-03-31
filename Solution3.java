class Solution{
	public void deleteNode(ListNode node){
		ListNode temp = node;
		node.val = temp.val;
		node.next = temp.next;
		temp.next = null;
	}
}
