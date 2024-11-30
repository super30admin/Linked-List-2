
public class DeleteNode {

	void deleteNode(Node node)
    {
         // Your code here
         node.data = node.next.data;
         node.next = node.next.next;
    }
}
