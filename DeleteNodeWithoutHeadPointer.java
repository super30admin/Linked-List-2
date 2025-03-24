public class DeleteNodeWithoutHeadPointer {
    class Solution {
        void deleteNode(Node node) {
            if (node == null || node.next == null) {
                return;
            }

            node.data = node.next.data;
            node.next = node.next.next;
        }
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
    }
}
