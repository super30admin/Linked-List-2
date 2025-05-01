
//Time Complexity: O(1)
//Space Complexity: O(1)

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

public class DeleteWithoutHeadPointer {
        void deleteNode(Node node) {
            // Your code here
            if(node.next != null){
                node.data = node.next.data;
                node.next = node.next.next;
            }
        }
}
