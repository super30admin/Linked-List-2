import org.w3c.dom.Node;
//Idea is to copy the value in the next node and replace it with the current node
// Time Complexity: O(1)
// Space Complexity: O(1)
public class DeleteNode {
        public void deleteNode(Node del_node) {
        // code here
        Node temp = del_node.next;
        del_node.data = temp.data;
        del_node.next = temp.next;
        temp = null;
    }
}
