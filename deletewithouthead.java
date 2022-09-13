// Java program to del the node in
// which only a single pointer is
// known pointing to that node
class LinkedList {

	static Node H;
	static class Node {

		int val;
		Node next;
		Node(int d)
		{
			val = d;
			next = null;
		}
	}

	void printList(Node node)
	{
		while (node != null) {
			System.out.print(node.val + " ");
			node = node.next;
		}
	}

	void deleteNode(Node node)
	{
		Node temp = node.next;
		node.val = temp.val;
		node.next = temp.next;
		System.gc();
	}

	public static void main(String[] args)
	{
		LinkedList list = new LinkedList();
		list.H = new Node(1);
		list.H.next = new Node(12);
		list.H.next.next = new Node(1);
		list.H.next.next.next = new Node(4);
		list.H.next.next.next.next = new Node(1);

		System.out.println("Before Deletion");
		list.printList(H);
		list.deleteNode(H);
		System.out.println("");
		System.out.println("After deletion ");
		list.printList(H);
	}
}

