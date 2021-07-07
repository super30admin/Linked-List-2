// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on GFG : Yes
// Any problem you faced while coding this : No

public class DeleteNode {
    void deleteNode(Node node)
    {
        if(node == null){
            return;
        }

        Node head = node;
        while(head.next != null){
            Node temp = head.next;
            head.data = temp.data;
            head = head.next;
        }

        Node headNew = node;
        while(headNew.next != null){
            if(headNew.next.next == null){
                headNew.next = null;
            } else {
                headNew = headNew.next;
            }
        }
    }
}
