import org.w3c.dom.Node;
// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

/*
    copy next element
 */
public class DeleteWithoutHead {
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
    void deleteNode(Node del)
    {
        int next = del.next.data;
        del.data = next;
        Node temp = del.next;
        del.next = temp.next;
        temp = null;
        return;
    }
}
