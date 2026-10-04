
//Time Complexity: O(1)
//Space Complexity: O(1)
class Node {
    int data;
    Node next;
    Node(int d)
    {
        data = d;
        next = null;
    }
}
public class DeleteNode {
    public void deleteNode(Node x) {
        // code here
        if (x == null || x.next == null) {
            return;
        }
        x.data = x.next.data;
        x.next = x.next.next;
    }
}
