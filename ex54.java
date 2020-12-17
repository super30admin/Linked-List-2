public class ex54 {
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

class GfG
{
    void deleteNode(Node node)
    {
         Node temp = node.next;
         node.data = temp.data;
         node.next = temp.next;
         temp = null;
    }
}
}
